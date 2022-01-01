- Create a yml file in the resources' directory to old auth keys
in the following format

````
base.url: https://myapi.com/v1/
client.key: ABC
client.secret: DEF
oauth.token: GHI
oauth.secret: JKL

stock:
  symbols: ibm,f
  fields: symbol,datetime,last,vl,adp_50,adp_100,adp_200
````

- name it api.yml.
  - if you change the name update import in application.yml
  - add to .gitignore so credentials aren't checked in
  - I believe I can use environment variables too
  - stock symbols are defaults, they can be passed in on request params



