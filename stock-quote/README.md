- Create a yml file in the resources' directory to old auth keys
in the following format

````
base.url: https://myapi.com/v1/
client.key: ABC
client.secret: DEF
oauth.token: GHI
oauth.secret: JKL
````

- name it api.yml.
  - if you change the name update import in application.yml
  - add to .gitignore so credentials aren't checked in
  - I believe I can use environment variables too



