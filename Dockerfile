FROM qaware/zulu-centos-payara-micro:8u192-5.184

CMD ["--hzconfigfile", "/opt/payara/hazelcast.xml", "--logproperties", "/opt/payara/logging.properties", "--deploymentDir", "/opt/payara/deployments"]

COPY src/main/docker/ /opt/payara/
COPY build/libs/jwks-javaee8-service.war /opt/payara/deployments/
