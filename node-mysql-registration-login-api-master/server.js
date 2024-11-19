require('rootpath')();
const express = require('express');
const app = express();
const cors = require('cors');
const bodyParser = require('body-parser');
const errorHandler = require('_middleware/error-handler');
const eurekaClient = require('./users/eureka-client'); // Import the Eureka client configuration

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cors());

// API routes
app.use('/users', require('./users/users.controller'));

// Global error handler
app.use(errorHandler);

// Start server
const port = process.env.NODE_ENV === 'production' ? (process.env.PORT || 80) : 4000;
app.listen(port, () => {
    console.log('Server listening on port ' + port);

    // Start the Eureka client to register the service
    eurekaClient.start((error) => {
        if (error) {
            console.error('Failed to register with Eureka:', error);
        } else {
            console.log('Successfully registered with Eureka!');
        }
    });
});

// Gracefully unregister from Eureka when shutting down
process.on('SIGINT', () => {
    eurekaClient.stop(() => {
        console.log('Service unregistered from Eureka');
        process.exit(0);
    });
});
