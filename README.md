# asaprappy

## BUILD

>cd <asaprappy project root>
>mvn clean package

## DEPLOY TO LOCAL TOMCAT

>cp target/asaprappy-x.x.x.war <apache install>/webapps/asaprappy.war

## DEPLOY TO EC2 TOMCAT

See https://docs.aws.amazon.com/quickstarts/latest/vmlaunch/step-1-launch-instance.html and https://docs.aws.amazon.com/quickstarts/latest/vmlaunch/step-2-connect-to-instance.html for launching an instance, creating a key pair and ssh'ing to the host.

>scp target/asaprappy-x.x.x.war -i <path to pem file> ec2-usr@<ec2host>:/home/ec2-user/asaprappy.war
>ssh -i <path to pem file> ec2-usr@<ec2host>
>cp asaprappy.war <apache install>/webapps/
