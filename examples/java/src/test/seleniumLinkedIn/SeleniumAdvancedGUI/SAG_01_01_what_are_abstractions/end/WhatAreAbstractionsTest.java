package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_01_01_what_are_abstractions.end;

/*

Abstractions is an important concept for designing with code.

In this video we will understand what abstractions mean in the
context of automated execution code for encapsulation,
loose coupling, delegation and ultimately as Dijkstra wrote:

"The purpose of abstraction is not to be vague,
but to create a new semantic level in which one
can be absolutely precise."

"The Humble Programmer" by Edsger W. Dijkstra
https://www.cs.utexas.edu/~EWD/transcriptions/EWD03xx/EWD340.html

---


Abstractions are used with all types of automating. When working with Web GUIs and WebDriver there are some common types of abstractions that we might expect to see. This video will provide an overiew of the material the course will cover to set the scene. It will be slide based. The course will proceed through the various types of abstractions working from very low level abstractions up to higher level domain abstractions like logical domain objects like Users who can manipulate the application. MEntion that WebDriver is an abstraction - an abstraction for a logical browser, which uses Drivers and these are abstractions for specific browsers, they use an interface to allow us to ignore the actual details in our code.


Coding Heuristics you may have seen:

- DRY - helps with maintainability - change code in one place
- Composition Over Inheritance - most of our abstractions are going to rely on composition creating objects which map on to something else and are then used within something. We may implement interfaces when there are common behaviours we want across different objects.
- YAGNI - refactor to abstractions rather than create a framework from scratch this way you only have what you need
- Readability - abstractions are there so we write the code at the appropriate level for the test, not because we have methods and objects we can re-use
- Single Responsibility - change code for one reason

We are also going to have:

- easy to write - harness code completion,
make it easier to train people in automating
by using our existing abstractions

 */
public class WhatAreAbstractionsTest {
}
