**Stepstone assignment:**
-

**Text:**

Having a JSON of a company structure as an input,

A. Write java classes capable of representing data from the JSON

B. Write two methods for:

1. Counting the total number of credits that the root company has access to, provided that:

    - The root company can make use of all credits assigned to it, to its sub-companies, and to all users within the company hierarchy.
        
2. When a Company ID is provided as an input, calculate the number of credits the company has access to, provided that:

    - The company can use its own credits and all credits assigned to its sub-companies
    - The company cannot use any of the users’ credits within its hierarchy


**Solution comments:**

About tools and libraries used:
* Maven was used as dependency manager and build tool.
* JUnit was used in the unit tests and some assertions in the main class.
* Jackson was used as the library for the unmarshalling of the json.
* The web tool https://jsonschema.net was used to deduce an initial json schema from the json example. Then it was 
manually edited to correct it get the version placed in main/resources/json/schema/schema.json.
* The web tool http://www.jsonschema2pojo.org/ was used to generate the Java POJOs with Jackson annotations from the 
json schema. Then they manually edition after the generation was necessary. They are placed in package 
uy.com.mattia.hw.stepstone.model

About the implementation:
* I don't have previous experience with json-schema and little with Jackson annotations. I'm used normally to work with 
xsd and then generate the POJO through jaxb instead. Then Jackson has enough support to use Jaxb generated pojos and 
to interpret the jaxb annotations. 
That's why the schema and annotations use might be "precarious". Anyway I chose to do the long way (defining an schema 
and then trying to do a generation of the POJO instead of writing them manually) because I thought it's the correct thing 
to do and also because that let me learn a little about json schema.
* The methods to count credits are implemented in uy.com.mattia.hw.stepstone.CreditsCounter. The only thing remarkable 
is that the iterative solution must be implemented to work around java' lack of tail recursion optimization.
* Unit test are provided.
