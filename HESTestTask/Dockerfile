FROM openjdk:17
WORKDIR /hes-test-task
COPY . ./
RUN ["chmod", "+x", "/hes-test-task/build_commands.sh"]
ENTRYPOINT ["/hes-test-task/build_commands.sh"]

