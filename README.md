# NetBuilder-Task2
This is the repository for the second and more complicated NETBuilder Assessment task.
## The Task

Create a class Family with the following methods. All arguments are strings: names of persons. Upon the first use of a name, that name is added to the family.

⦁	`male(name)`and `female(name)` returning **boolean**

Define the gender (corresponding to the method name) of the given person. Return false when these assignments cannot be made because of conflicts with earlier registered information.

⦁	`isMale(name)` and `isFemale(name)` returning **boolean**

Return **true** when the person has the said gender. When no gender was assigned, both methods should return **false**

⦁	`setParent(childName, parentName)` returning **boolean**

Defines the child-parent relationship between two persons. Returns **false** when the relationship cannot be made because of conflicts with earlier registered information.

⦁	`getParents(name)` and `getChildren(name)` returning **array of string**

Return the names of the person's parents/children in alphabetical order

### The Implementation

I created a Person class, which contained all the relevant information on a person:
- `String name` - Contains the name, in this case, the unique identifier
- `String gender` - Designed to be one of four possibilities: "female", "undefined", "male" or null
- `ArrayList<Person> offspring` - A List of the children of this person, used for the relationships
- `ArrayList<Person> parents` - As is biology, everyone has parents, this list holds them

The specification mandated "Family" class was created to house the majority of functions including:
- **`setParent()`** - Which set the parent. By creating a child, parent or both if they did not exist I avoided NullPointerExceptions. 
- **`isMale()`** - As per the brief, this checks the gender of the person the given name belongs to and returns true or false if they are male or not.
- **`isFemale()`** - As per the brief, this checks the gender of the person the given name belongs to and returns true or false if they are female or not.
- **`male()`** & **`female()`** - Once again as described in the task, these functions assign the corresponding gender to the given name of a person, and uses a parental relationship checker to judge if this parent is male or female based on their "spouse".
- **`getParents()`** - Finds the parent, or parents of a particular person.
- **`getChildren()`**  - As implied by the name, this function returns the list of children, or an empty list, depending on the given name.
- **`findPerson`** - The staple of the program, uses a persons name to check against a family object to find the relevant person. Given that the *name* of a person is unique, checks were not needed as to duplicates.

### The Rules
Although the task relates to genealogy, the rules of this task are not claimed to be realistic. Several simplifications and rules apply, which may not hold in real life:

1.	Strings are case sensitive, but there are no tests playing around with "Peter", "PETER" and "PeTeR".
2.	People are uniquely identified by their name. For instance, there are no two different people called "Jim" in the same family.
3.	Once a person has an assigned gender, it cannot be changed.
4.	No gender conclusions should be made from personal names: "Bob" could well be a woman and "Susan" a man.
5.	People cannot have more than one mother and one father.
6.	The terms "parents" and "children" refer to the relatives in the immediate previous/next generations only, not to more remote ancestors or descendants.
7.	Incest may occur, so, for example, one's parent may at the same time be their grandparent.
8.	One cannot be their own ancestor.
9.	Age is not accounted for. Even if some incestuous relationships would infer that one's parent is more than 5 generations older, it should be allowed.
10.	In case a name's first occurrence is in a call of one of the two gender querying methods, the return value will always be false, as that new person does not have a known gender.
11.	In case a name's first occurrence is in a call of one of the two relation querying methods, the return value will always be an empty array/list, as there are no relationships known yet in which that new person participates.
12.	For the reasons in the preceding two bullet points it should not matter whether you actually store that name in these cases in your data structure, or not. In the latter case you would only store it at the next occasion when that name is mentioned in a call of one of the three other methods, that actually add information. The described interface has no way to query the difference between these two possible implementations, so you can choose freely.

They were adhered to or acknowledged in the following ways:
- Rule 1: As there were no specifications to handle different naming conventions, this was overlooked.
- Rule 2: Having no two people in the same family names "Jim", or some such like, meant name could be unique.
- Rule 3: No gender reassignments after initial assignment.
- Rule 4: Gender was based on relationships to those who had set gender. ("spouses" had opposite genders)
- Rule 5: The "Parents" could only be a certain length and as such would not allow any more parents to a child
- Rule 6: The relationships went up and down only. No grandchildren associations made.
- Rule 7: No rules preventing incest.
- Rule 8: Prevented by stopping parental assignment with same name.
- Rule 9: No age counter or restrictions used.
- Rule 10: The **`isMale/Female()`** functions only return true if the values are an exact match to their genders.
- Rule 11: An empty list is returned if there are not relations.
- Rule 12: Information stored on class scoped ArrayList.


### Testing
A majority of the testing was possible due to the example output code given on the brief. However, as is best practice, to achieve 70% coverage on code, tests were added. Such as a test for the **`female()`** function and other gender specific calls.

![Test Coverage](Test&#32;Coverage.png)


