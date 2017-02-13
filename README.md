# biggis-download-aws-sentinel-data
Download client to obtain sentinel satellite data from AWS

This repository contains a HTTP client to download [Sentinel satellite images from AWS](http://sentinel-pds.s3-website.eu-central-1.amazonaws.com/).
It can be configured with a parent directory and will recursively download all subdirectories. 
Additional filters can be applied to constrain the downloads to certain directories, e.g. dates.
Already downloaded files will be skipped.
Failing downloads will be retried.
From experience it may be necessary to restart the download to obtain a full dataset.

The client is implemented with Apache Camel and Spring Boot.
It uses the AWS S3 Rest API as this seems to produce more stable results.

Please mind the [terms and conditions](https://scihub.copernicus.eu/twiki/do/view/SciHubWebPortal/TermsConditions) of the Sentinel data.
