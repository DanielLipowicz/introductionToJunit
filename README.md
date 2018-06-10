<h1> Introduction to Junit tests </h1>


<h3>For class Calculator create following junit assertion:</h3>
 > For that purpose use junit assertion library
<li>Check is your number is even number</li>
<li>Check is your number is NOT even number</li>
<li>Check is your numbers sum correct</li>
---------------------
<li>Create two variables and assign new Calculator class instance. After that check is NOT the same object</li>
<li>Create two variables and assign value from static method Calculator.getInstance(). After that check is the same object</li>

<li>Try to prove that calculator instance is null when application starts</li>
<li>Try to prove that calculator instance is NOT null after Calculator.getInstance have been invoked</li>

<li>Check if you try to divide by zero, then you get runtime exception</li>

<h3>Data driven test</h3>
<li>Create parametrized test for testing particular calculator method
    <li>https://github.com/junit-team/junit4/wiki/parameterized-tests</li>
</li>


<h2>Hamcrest</h2>
<h3>Using hamcrest create following tests:</h3>
<li>Check is data server return instance of dataServer</li>
<li>Check is data returnedFromSerer is in ArrayList instance</li>
<li>Ensure that you are able to add new item to local instance</li>
<li>Ensure that after migration global database contain all records from local</li>

<h2>Links</h2>
http://www.vogella.com/tutorials/Hamcrest/article.html
