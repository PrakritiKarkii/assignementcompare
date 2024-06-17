-- Create a new database
CREATE DATABASE social_media_engagement;

-- Use the newly created database
USE social_media_engagement;

-- Create a table to store engagement data
CREATE TABLE engagement_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    platform VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    engagement_count INT NOT NULL
);
-- Insert sample data into the engagement_data table
INSERT INTO engagement_data (platform, date, engagement_count)
VALUES 
    ('Facebook', '2024-01-01', 1000),
    ('Facebook', '2024-02-01', 1100),
    ('Facebook', '2024-03-01', 1150),
    ('Twitter', '2024-01-01', 800),
    ('Twitter', '2024-02-01', 850),
    ('Twitter', '2024-03-01', 900),
    ('Instagram', '2024-01-01', 1200),
    ('Instagram', '2024-02-01', 1250),
    ('Instagram', '2024-03-01', 1300);
