const { Eureka } = require('eureka-js-client');

// Configure Eureka client
const client = new Eureka({
    instance: {
        app: 'NODE-USER-SERVICE',  // Name of your service
        instanceId: 'NODE-USER-SERVICE:4000',  // Unique instance ID
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: {
            '$': 4000,  // Service port
            '@enabled': true
        },
        vipAddress: 'NODE-USER-SERVICE',
        statusPageUrl: 'http://localhost:4000/status',  // Link shown in Eureka
        homePageUrl: 'http://localhost:4000',  // Optional: Another link for the service homepage
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn'
        }
    },
    eureka: {
        host: 'localhost',  // Eureka server hostname
        port: 8761,  // Eureka server port
        servicePath: '/eureka/apps/',  // Default path for registering apps
        maxRetries: 10,
        requestRetryDelay: 5000
    }
});

module.exports = client;
