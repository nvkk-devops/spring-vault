# Spring Vault integration

## Default Backend Integration
### step:1 - Configure Connection - bootstrap.properties
* Initialize the vault settings. URL, token

### step:2 - Configure Secrets - Vault Console UI
* Login to Vault console : http://<vault-url-or-localhost>:8200/ui
    Method = Token
    Token = <token-from-vault-startup>

* Create secrets from : select 'secret'. Sample entries

* Refer to [Vault](https://www.vaultproject.io/docs/install) documentation for installation and configuration

```
Path of the secret = application
Version Data: <key, value> pairs
    login=nvkk-user1 
    password=user123
````
 
### step:3 - Vault Console UI 
* Create configuration class 'VenkatVaultConfiguration.java' to refer above vault keys
```
@Configuration
public class VenkatVaultConfiguration {

    @Value("${login}")
    private String login;

    @Value("${password}")
    private String password;
....
}
```

### step:4 - Restart and Validate Logs
```
mvn springboot run

... notice below log info
logger.info("Login :: "+ venkatVault.getLogin());
logger.info("Password :: "+ venkatVault.getPassword());

```

## Custom Backend Integration

### Configure Custom Backend - Vault Console UI
```
backend = venkata-secrets
secret-path = mongodb-credentials

```

### Update - bootstrap.properties
```
## NOTE: Configure custom back-end from vault-console-ui
spring.cloud.vault.generic.backend=venkata-secrets
spring.cloud.vault.generic.default-context=mongodb-credentials
```