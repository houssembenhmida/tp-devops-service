FROM houssemeddinebenhmida/promethus-jmx_exporter-tomcat
COPY . /home/centos/project/
RUN ls -al /home
RUN ls -al /home/centos
RUN ls -al /home/centos/project
RUN rm /home/centos/project/Dockerfile
RUN rm /home/centos/project/upa.xml
RUN ls -al /home/centos/project
RUN chgrp -R 0 /home/ && \
    chmod -R g=u /home/
RUN chgrp -R 0 /home/centos/ && \
    chmod -R g=u /home/centos/
RUN chgrp -R 0 /home/centos/libs && \
    chmod -R g=u /home/centos/libs
RUN chgrp -R 0 /home/centos/libs/apache-maven-3.5.4/ && \
    chmod -R g=u /home/centos/libs/apache-maven-3.5.4/
RUN chgrp -R 0 /home/centos/libs/apache-maven-3.5.4/bin && \
    chmod -R g=u /home/centos/libs/apache-maven-3.5.4/bin    
RUN chgrp -R 0 /bin && \
    chmod -R g=u /bin
RUN ls -al /home/centos/libs/apache-maven-3.5.4/bin
RUN ls -al /bin
WORKDIR /home/centos/project/
RUN /home/centos/libs/apache-maven-3.5.4/bin/mvn clean install 
RUN rm -Rf /usr/local/tomcat/webapps/*
RUN cp /home/centos/project/app/PaasProject-app-web/target/PaasProject.war /usr/local/tomcat/webapps/ROOT.war
#COPY service/app/PaasProject-app-web/target/PaasProject.war /usr/local/tomcat/webapps/ROOT.war
RUN chgrp -R 0 /usr/local/tomcat/ && \
    chmod -R g=u /usr/local/tomcat/
CMD ["catalina.sh", "run"]
EXPOSE 8080
EXPOSE 8081
