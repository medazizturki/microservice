# Use the official Node.js 18 base image
FROM node:18

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json (if available)
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the entire project directory to the container's working directory
COPY . .

# Expose the port your app runs on
EXPOSE 4000

# Command to run your application
CMD ["node", "server.js"]
