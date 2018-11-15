#!/bin/bash

echo "Provisioning infrastructure..." 

echo "Finding my public ip address..." 
MY_PUBLIC_IP="$(curl -s ipinfo.io/ip)"
echo "... test your public ip is $MY_PUBLIC_IP"

echo "Starting terraform..."
terraform apply -var "my_public_ip=177.41.58.100/32"