# APItesting
This repository was created with the purpose of uploading the information asked by the Globant TAE group

Automation for API

###  Credentials
Mock API credentials: https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users/

Jira Credentials:    User/Pass

###  Specifications and steps to run the exercise

- dowload the repository api automation
- run

*Note: it contais three test
1. testOne: the first test validates that there is no data within the endpoint, if so, it deletes all the data. Additonally it has two asserts, one for the http get and another for the http delete method.
2. testTwo: the second test initialize the pojo with 20 users with random data and it has a code verification that avoids the duplicity of emails. Additionaly it has two asserts one for the get and another one for the post method
3. testThree: the third test deletes all the existing records and tries to create 4 records with random data but with static emails. The idea is to create a test that it breaks when creating users with duplicate emails.