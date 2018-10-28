terraform {
    backend "s3" {
        bucket = "araujohelder-beerstore-state"
        key = "beerstore-curso-online"
        region = "us-east-1"
        profile = "terraform"
    }
}