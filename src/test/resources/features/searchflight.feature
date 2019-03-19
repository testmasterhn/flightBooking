Feature: Search Flight

Scenario Outline: Search Flight
Given User is staying on booking page
When User book the journey with <Type> from <Departure> to <Destination> on <From> to <To> for <Adults> adults and <Children> children and <Baby> baby
Then User should see list of flight suitable with his journey
Examples:
|Type				| Departure	| Destination	| From			| To				| Adults	|Children	| Baby	|
|Round-trip	| Hà Nội		| Hồ Chí Minh	| 20-03-2019| 19-04-2019| 3				| 1				| 0			|