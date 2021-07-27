
# Smart-Reader

## Building blocks

- spring batch
- postgres
- lombok
- flyway

## Init environment

In order to run the application you first need to have a Postgres Data Base up and running.

If you want to use your own database, you can do it as well, but I have provided docker yml with a basic postgres in it.<br>
To run the provided postgres db, just run the following command (assuming you have docker and docker-compose installed).

    $ cd /to/project/root 
    
    $ docker-compose up -d

