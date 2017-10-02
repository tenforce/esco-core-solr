# Solr Engine

War-based Solr Engine to be deployed in WebLogic, under the EC premises.
Uses an old version of Solr which fulfills the deployment requirements.

Admin console:

`http://localhost:8080/solr/#/collection1`

Check the docker-compose file of the platform using it for the port (eg 8893).


## Configure Solr:

Uses the configuration in `./profiles/dev`.

In particular, the following files are of interest.

`./profiles/dev/config/schema.xml`: Declares how the documents are indexed, and how the indexed can be searched.

`./profiles/dev/config/solrconfig.xml`: Defines the HTTP endpoints. For this project, `/query` and `/mlt` are of special interest.

This directory also contains lists with stop words etc. A lot of these are taken from:
https://github.com/lucidworks/silkusecases/tree/master/searchanalytics/solrsearchlogs/conf/lang

## Maven deployment

### Run standalone (heavily recommended while developing your own SOLR config, since you can immediately see the changes)

mvn jetty:run -p dev
