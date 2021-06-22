# Application.Properties Setup Instructions

### Initial Steps:

1. Create a new file in the resources folder called "application.properties"
1. Copy the contents of "application.properties.example" into this file.
1. From here, you have to update the DB and Security settings.
  - You can also change some of the basic settings I left in.

### Changing Basic Settings:

1. Edit the setting for automatically creating the tables with "spring.jpa.hibernate.ddl"
1. Edit the setting for displaying the SQL log with "spring.jpa.show-sql"
1. Edit the setting for formating the SQL log with "spring.jpa.properties.hibernate.format_sql"

### Updating DB and Security Settings:

1. Change the name and password for the "Spring Security Criteria" inside the brackets.
1. Uncomment (remove the #) from the set of DB settings based on the machine the DB is running on.
  - You can delete the commented out settings
1. Change the URL to match the URL of your DB repo.
  - Mac and Linux machines will need to update the serverTimezone variable to match the machine's as well.
1. Change the "spring.datasource" username and password in brackets to match the repo's own.