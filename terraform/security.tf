resource "aws_security_group" "allow_ssh" {
    vpc_id = "${aws_vpc.main.id}"
    name = "beerstore_allow_ssh"

    ingress {
        from_port = 22
        to_port = 22
        protocol = "tcp"
        cidr_blocks = ["168.227.234.59/32"]
    }

}