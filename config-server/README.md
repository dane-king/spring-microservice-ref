Followed this article to setup 
https://www.thomasvitale.com/spring-cloud-config-basics/
By default this points to a local git repository
- {user-dir}/config-repo
- default looks for a main branch in Spring boot version 3.+, not master
  - can add a property to change
    - spring.cloud.config.server.git.default-label=main

- add appropriate application files
  /{application}/{profile}[/{label}]
  /{application}-{profile}.yml
  /{label}/{application}-{profile}.yml
  /{application}-{profile}.properties
  /{label}/{application}-{profile}.properties
- example application-stockQuote-dev.yml