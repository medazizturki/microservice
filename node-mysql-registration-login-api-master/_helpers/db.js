const mysql = require('mysql2/promise');
const { Sequelize } = require('sequelize');

// Export the db object
module.exports = db = {};

initialize();

async function initialize() {
    // Use environment variables for database configuration
    const host = process.env.DB_HOST || 'localhost';
    const port = process.env.DB_PORT || 3307;  // Use port 3307 for mysql_node
    const user = process.env.DB_USER || 'root';
    const password = process.env.DB_PASSWORD || 'root';
    const database = process.env.DB_NAME || 'node_user_service';

    try {
        // Create a connection to MySQL server and ensure the database exists
        const connection = await mysql.createConnection({ host, port, user, password });
        console.log('Connected to MySQL Server...');
        await connection.query(`CREATE DATABASE IF NOT EXISTS \`${database}\`;`);
        console.log(`Database "${database}" checked/created.`);

        // Connect Sequelize to the database
        const sequelize = new Sequelize(database, user, password, {
            host,
            port,
            dialect: 'mysql',
            logging: false, // Disable logging for a cleaner output
        });

        console.log('Sequelize connected...');

        // Initialize models and add them to the db object
        db.User = require('../users/user.model')(sequelize);

        // Sync all models with the database
        await sequelize.sync();
        console.log('All models were synchronized successfully.');
    } catch (error) {
        console.error('Error initializing the database:', error.message);
        process.exit(1); // Exit the application if database initialization fails
    }
}
