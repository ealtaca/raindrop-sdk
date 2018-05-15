# Android library for Hydro Raindrop Api
<img src="https://www.hydrogenplatform.com/images/logo_hydro.png">

## Introduction
<p>The Hydro Smart Contract is open source blockchain software developed by <a href="https://www.hydrogenplatform.com/">Hydrogen Platform</a>.</p>
<p>This android library provides simple usage for raindrop api which is developed by hydrogenplatform.</p>

<p>For more details, please check <a href="https://www.hydrogenplatform.com/docs/hydro/v1/">Hydrogen Raindrop Api Docs</a>

## Getting Started

    IHydroAuthenticator hydroAuthenticator = new HydroAuthenticator("API_KEY", "API_USERNAME", "USE_TESTNET true/false");
   

### Step 1: Add address to whitelist ( be careful, for security purposes, this id will only be generated one time. )

    Whitelist whitelist = hydroAuthenticator.whitelist("Hydro/Ethereum ADDRESS 0x12312..."); 
    
    whitelist.isSuccess(); //api call is success (200)
    whitelist.getMessage(); //error response content
    
    whitelist.getHydroAddressId(); //get address id
     
    
### Step 2: Get Raindrop details

    Challenge challenge = hydroAuthenticator.challenge("HYDRO_ADDRESS_ID");
    
    whitelist.isSuccess(); //api call is success (200)
    whitelist.getMessage(); //error response content
    
    // Set quantity of Hydro tokens to send to the blockchain. Since our token has 18 decimal places, the number that you will need to send may seem large, but remember that the 18 rightmost digits are actually decimals. For example, 313823208533000000 is actually .313823208533000000 Hydro.
    challenge.getAmount();
    
    // Randomly generated string used to confirm the validity of the transaction. Only the client requesting the challenge will know the value.
    challenge.getChallenge(); 
    
    // The ID assigned to your firm which will be the same for all authentication requests.
    challenge.getPartnerId();  

### Step 3: Check on exist valid Raindrop transaction

    Authenticate authenticate = hydroAuthenticator.authenticate("HYDRO_ADDRESS_ID");
    
    // check is authenticated
    authenticate.isAuthenticated();
    
