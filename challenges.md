# Challenges while developing the PadelApp
While developing the PadelApp, we have discovered alot of hidden issues that had to be fixed and resulted in haulted progress. This in the end made it impossible for us to meet all our expectations for the application.

## REST-API-testing
Even though the REST-API works as intended when tested manually, making unit tests for the api proved to be way more complicated than expected.

The main issue has been understanding how the testing should be implemented, and looking at the todoList project proved to be of little help.

We have tried using the SpringBootTestServer, with and without RestTemplate and MockMvc without success. We have tried getting help on teams, but the knowledge they possesed on this matter was limited and they didnt manage to help us at all.

After repetead try and error it has become impossible to implement unit testing for the REST-API because of the time constraint we had.

