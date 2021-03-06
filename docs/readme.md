class: center, middle

# Pure FP ?

 🤔

### A journey from imperative OO to pure functional programming

Jules Ivanic • `@guizmaii`

???
- Bonjour
- Merci à vous
- Merci à Scaleway
- Mathieu
---

# Who am I ?

## Jules Ivanic .large[• `@guizmaii`]

 - 30 years old

 - Professional developer for 7 years.

 - Mostly Scala/FP developer today

 - Ex-CTO @ Colisweb .small[(Ils recrutent: https://www.welcometothejungle.co/fr/companies/colisweb)]

 - Always learning

 - Passionate surfer since I'm 11. Leaving to Australia in June 🌊🏄

???
Empty
---
# Summary

 1. Motivation

 2. Disclaimer

 3. Functional programming ? 🤔

 4. What is a function in (pure) FP ?

 5. Why do we restrict ourself to pure functions ?
  
 6. Imperative OO

 7. Impure FP

 8. Pure FP

 9. Conclusion

 10. Questions

---
class: center, middle

# 1. Motivation

---
# 1. Motivation
.center[
Explain my transition .bold[from Impure FP to Pure FP] and its benefits
]
---
# 1. Motivation

.center[

Explain my transition .bold[from Impure FP to Pure FP] and its benefits

but

]
---
# 1. Motivation

.center[

Explain my transition .bold[from Impure FP to Pure FP] and its benefits

but

I ended up writing a kind of (bad) Rosetta Stone. 😅

<img src="Rosetta_Stone.JPG" alt="Pierre de Rosette" width="270" height="316" />
]
---
class: center, middle

# 2. Disclaimer

---
# 2. Disclaimer

<br />
<br />
<br />

.center[

![Image](jdg_wisdom.png)

]

???
Apprendre est un processus personnel. Je ne peux rien vous apprendre.
Je peux vous montrer, vous expliquer mais la compréhension de ce que je vous montre/explique se passe dans votre tête.

Apprendre demande du travail personnel. Vous n'apprenez pas juste en regardant un talk.

Sur des sujets non triviaux, il faut que vous trouviez votre propre "intuition".
C'est cette intuition qui vous permet de comprendre les choses complexes.

Je peux vous partager mon intuition, plus quelques autres si j'en connais d'autres.
Si une de ces intuitions vous parle, cool. Cela va vous permettre de comprendre.
Sinon, il va falloir que vous travailliez pour réussir à trouver votre propre intuition.
Ce processus peut-être long. Cela dépend de plein de paramêtres: du sujet, de votre proximité avec celui-ci, etc.

Pour moi, cette notion d'"intuition" est essentiel, c'est pourquoi je tenais à prendre ces deux minutes pour vous en parler.
---
class: center, middle

# 3. Functional programming ? 🤔

---
# 3. Functional programming ? 🤔

<br />
.center[
## Functional Programing is programming with functions
]
---
# 3. Functional programming ? 🤔

<br />
.center[
## Functional Programing is programming with functions
]
<br />

.bold[What does this mean ?]
---
# 3. Functional programming ? 🤔

<br />

.center[
## Functional Programing is programming with functions
]
<br />

.bold[What does this mean ?]

It means that functions are .bold[first-class values]:

```scala
val f: `String => Int` = (s: String) => s.size      // a function is a Type, just like String, Int, Person, etc.

def map[F[_], A, B](a: F[A], `f: A => B`): F[B]     // A function can take a function in parameter

def parse[A, B](value: String): `(A, String) => B`  // A function can return a function
```

---
# 3. Functional programming ? 🤔

<br />

.center[
## Functional Programing is programming with functions
]

<br />

.bold[What does this mean ?]

.bold[What is programming ?]
---
# 3. Functional programming ? 🤔

<br />

.center[
## Functional Programing is programming with functions
]

<br />

.bold[What does this mean ?]

.bold[What is programming ?]

Seriously ? 😄
---
# 3. Functional programming ? 🤔

<br />

.center[
## Functional Programing is programming with functions
]

<br />

.bold[What does this mean ?]

.bold[What is programming ?]

.bold[What is a function ?]
---
# 3. Functional programming ? 🤔

<br />

.center[
## Functional Programing is programming with functions
]

<br />

.bold[What does this mean ?]

.bold[What is programming ?]

.bold[What is a function ?]

And here's the real interesting question!
---
class: center, middle

# 4. What is a function in (pure) FP ?

---
# 4. What is a function in (pure) FP ?

<br />
<br />
<br />
<br />
<br />

.center[
## A function in (pure) FP is a mathematical function,<br /> also called "pure function"
]

---
# 4. What is a .red[pure] function ?

A pure function is a function that respects:

- .bold[Totality]                 (defined for every possible values of its input types)

- .bold[Determinism]              (same inputs will always produce same outputs)

- .bold[Referencial transparency] (produce its output and nothing else)
---
# 4. What is a .red[pure] function ?

A pure function is a function that respects:

- .bold[Totality]                 (defined for every possible values of its input types)

.underlined[Counter examples:]

```scala
def divide0(a: Int, b: Int): Int = if (b == 0) null else a / b
def divide1(a: Int, b: Int): Int = if (b == 0) throw new RuntimeException("...") else a / b
```

- .bold[Determinism]              (same inputs will always produce same outputs)

- .bold[Referencial transparency] (produce its output and nothing else)
---
# 4. What is a .red[pure] function ?

A pure function is a function that respects:

- .bold[Totality]                 (defined for every possible values of its input types)

- .bold[Determinism]              (same inputs will always produce same outputs)

.underlined[Counter examples:]

```scala
def randMult(a: Int): Int     = Random.nextInt * a
def isToday(d: Date): Boolean = Date.today == d
```

- .bold[Referencial transparency] (produce its output and nothing else)
---
# 4. What is a .red[pure] function ?

A pure function is a function that respects:

- .bold[Totality]                 (defined for every possible values of its input types)

- .bold[Determinism]              (same inputs will always produce same outputs)

- .bold[Referencial transparency] (produce its output and nothing else)

.underlined[Counter examples:]

```scala
def mult(a: Int, b: Int): Int = {
  val res = a * b
  launchMissile()
  res
}
```
---
# 4. What is a .red[pure] function ?

A pure function is a function that respects:

- .bold[Totality]                 (defined for every possible values of its input types)

- .bold[Determinism]              (same inputs will always produce same outputs)

- .bold[Referencial transparency] (produce its output and nothing else)

.underlined[Counter examples:]

```scala
def mult(a: Int, b: Int): Int = {
  val res = a * b
  launchMissile()
  res
}

// This simplistic program:
val r0 = mult(1, 2) + mult(2, 3)
```
---
# 4. What is a .red[pure] function ?

A pure function is a function that respects:

- .bold[Totality]                 (defined for every possible values of its input types)

- .bold[Determinism]              (same inputs will always produce same outputs)

- .bold[Referencial transparency] (produce its output and nothing else)

.underlined[Counter examples:]

```scala
def mult(a: Int, b: Int): Int = {
  val res = a * b
  launchMissile()
  res
}

// This simplistic program:
val r0 = mult(1, 2) + mult(2, 3)

// Is not equivalent to this one:
val r1 = 2 + 6
```
---
# 4. What is a .red[pure] function ?

A pure function is a function that respects:

- .bold[Totality]                 (defined for every possible values of its input types)

- .bold[Determinism]              (same inputs will always produce same outputs)

- .bold[Referencial transparency] (produce its output and nothing else)

.underlined[Counter examples:]

```scala
def mult(a: Int, b: Int): Int = {
  val res = a * b
  launchMissile()
  res
}

// This simplistic program:
val r0 = mult(1, 2) + mult(2, 3)

// Is not equivalent to this one:
val r1 = 2 + 6

// So the 'mult' function is not referencially transparent
```
---
class: center, middle

# 5. Why do we restrict ourself to pure functions ?

---
# 5. Why do we restrict ourself to pure functions ?

Because this constraint enables a simple and natural mode of .bold[reasoning] about program evaluation called the .bold[substitution model].
---
# 5. Why do we restrict ourself to pure functions ?

Because this constraint enables a simple and natural mode of .bold[reasoning] about program evaluation called the .bold[substitution model].

<br />

if we know that .blue[`f(x)`] returns .blue[`y`] and know that `f` is pure<br />
---
# 5. Why do we restrict ourself to pure functions ?

Because this constraint enables a simple and natural mode of .bold[reasoning] about program evaluation called the .bold[substitution model].

<br />

if we know that .blue[`f(x)`] returns .blue[`y`] and know that `f` is pure<br />
then we can replace any .blue[`f(x)`] call by its result, .blue[`y`]
---
# 5. Why do we restrict ourself to pure functions ?

Because this constraint enables a simple and natural mode of .bold[reasoning] about program evaluation called the .bold[substitution model].

<br />

if we know that .blue[`f(x)`] returns .blue[`y`] and know that `f` is pure<br />
then we can replace any .blue[`f(x)`] call by its result, .blue[`y`]<br />
.bold[without the fear of changing] the behavior of the program
---
# 5. Why do we restrict ourself to pure functions ?

Because this constraint enables a simple and natural mode of .bold[reasoning] about program evaluation called the .bold[substitution model].

<br />

if we know that .blue[`f(x)`] returns .blue[`y`] and know that `f` is pure<br />
then we can replace any .blue[`f(x)`] call by its result, .blue[`y`]<br />
.bold[without the fear of changing] the behavior of the program

<br />

In other words, pure functions enable .bold[equational reasoning] about programs.

<br />
<br />
<br />

[What Referential Transparency can do for you - Luka Jacobowitz](https://www.youtube.com/watch?v=X-cEGEJMx_4)
???
raisonnement équationnel

It's a HUGE benefit because, now your program are really simple to read and understand.<br />
You don't anymore have to track variables mutations (immutability ❤️), nor any external state, nor find your way in multiples ways.
There's one way of evaluation: from the top of the tree to the bottom.
---
class: center, middle

# 6. Imperative OO

---
# 6. Imperative OO

```java
// I used to write things like that...

class Person {

  private String name;
  private Int age;
  private String address;

  public Person(String name, Int age, String address) {

    if (age < 0 || age > 120) {
      throw new RuntimeException("age is invalid");
    }

    this.name = name; this.age = age; this.address = address;
  }

  public String getName {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  ...
}
```
---
# 6. Imperative OO

```java
// I used to write things like that...

class PersonRepo {

  private DB dbInstance;

  public PersonRepo(DB dbInstance) {
    this.dbInstance = dbInstance;
  }

  public void savePerson(Person p, GpsPoint point) {
    dbInstance.query(
      "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
      p.name, p.age, p.address, point
    )
  }
}
```
---
# 6. Imperative OO

```java
// I used to write things like that...

class GoogleService {

  private final HttpClient httpClient;

  public GoogleService(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public GpsPoint geocode(String address) {
    String res =
      httpClient
        .get("https://api.google.com/geocode/address")
        .body("{ \"address\": \"" + address + "\" }")
        .execute();

    return parse(res);
  }
}
```
---
# 6. Imperative OO

```java
class Server extends FrameworkMagic {

  private final GoogleService geocoder;
  private final PersonRepo    repo;

  /**
    * Accepted JSON requests:
    *
    * { "name": "Jules", "age": 30, "address": "Sydney, Australia" }
    */
  @Put("/person")
  public HttpResponse createPerson(@Body Person person) {
*    // TODO: Your mission, if you accept, is to code this method.
  }

}
```
---
# 6. Imperative OO

```java
@Put("/person")
public HttpResponse createPerson(@Body Person person) {

  GpsPoint point = geocoder.geocode(person.address);

  repo.savePerson(person, point);

  return HttpResponse.Created("Done 👍");
}
```
---
# 6. Imperative OO

```java
@Put("/person")
public HttpResponse createPerson(@Body Person person) {

  GpsPoint point = geocoder.geocode(person.address);

  repo.savePerson(person, point);

  return HttpResponse.Created("Done 👍");
}
```

<br />

.bold[Your nice ignorant boss 🤴 :]  Nice work. Here's your 💵

.bold[Me (your CTO) 👨‍🏫 :] You're fired. You waste our money.
---
# 6. Imperative OO

```java
@Put("/person")
public HttpResponse createPerson(@Body Person person) {

  GpsPoint point = geocoder.geocode(person.address);

  repo.savePerson(person, point);

  return HttpResponse.Created("Done 👍");
}
```

<br />

Problems in this code:
  - No error handling
  - Synchronous
  - Uncontrolled side effects
  - mutable
---
# 6. Imperative OO

```java
@Put("/person")
public HttpResponse createPerson(@Body Person person) {

  GpsPoint point = geocoder.geocode(person.address);

  repo.savePerson(person, point);

  return HttpResponse.Created("Done 👍");
}
```

<br />

.bold[
Let's improve that piece of code!
]

We'll make it asynchronous and we'll handle errors in the same time

Thanks to ???
---
exclude: true

# [A]synchronous, [non-]blocking ? 🤔

<br />

.center[
|                     | Synchronous                          | Asynchronous                  |
|---------------------|--------------------------------------|-------------------------------|
| .bold[blocking]     | Waste LOTS OF CPU resources          | Unsafe, waste resources       |
| .bold[non-blocking] | Nonsensical                          | Holy Grail 🏆                 |
]

<br />

[Latency numbers every programmer should know](https://gist.github.com/guizmaii/6395ad8abf1b1718f4a3128fec81f7ce)
---
class: center, middle

# 7. Impure FP

---
# 7. Impure FP

First, let's rewrite the `Person` class ...

```java
class Person {

  private String name;
  private Int age;
  private String address;

  public Person(String name, Int age, String address) {

    if (age < 0 || age > 120) {
      throw new RuntimeException("age is invalid");
    }

    this.name = name; this.age = age; this.address = address;
  }

  public String getName {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  ...
}
```
---
# 7. Impure FP

... in Scala

```scala
final case class Person(name: String, age: Int, address: String)
```
---
# 7. Impure FP

... in .bold[Scala]

```scala
final case class Person(name: String, age: Int, address: String)
```

<br />

.bold[BOOOMM] 🤩
---
# 7. Impure FP

... in .bold[Scala]

```scala
final case class Person(name: String, age: Int, address: String)
```

<br />

.bold[BOOOMM] 🤩

But why choose Scala ? Why not stay with Java ?

And also, is this code really equivalent to the previous Java one ?
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  def apply(name: String, age: Int, address: String): Person =
    if (age < 0 || age > 120) throw new RuntimeException("age is invalid")
    else                      new Person(name, age, address)

}

// Usage example:

val jules = Person("Jules", 30, "Sydney, Australia")
```

<br />

Now, it's equivalent to the Java code.
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  def apply(name: String, age: Int, address: String): Person =
    if (age < 0 || age > 120) throw new RuntimeException("age is invalid")
    else                      new Person(name, age, address)

}

// Usage example:

val jules = Person("Jules", 30, "Sydney, Australia")
```

<br />

Now, it's equivalent to the Java code.

.bold[Except that it's immutable] 🤩
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  def apply(name: String, age: Int, address: String): `Person` =
    if (age < 0 || age > 120) `throw new RuntimeException("age is invalid")`
    else                      new Person(name, age, address)

}

// Usage example:

val jules = Person("Jules", 30, "Sydney, Australia")
```

<br />

Now, it's equivalent to the Java code.

.bold[Except that it's immutable] 🤩


👨‍🏫: But with this code, you're still fired!
---
exclude: true
class: center, middle

# Axiom 0

## By default immutability is the absolute minimum you should have in your programming language and its stdlib collections.

#### If a language doesn't offer you that, quit this language!
#### It doesn't worth any effort from you nor anyone.

.right.small[Jules Ivanic]

.left.small[https://twitter.com/guizmaii/status/966370888898744320]
.left.small[https://twitter.com/guizmaii/status/1036580744360062976]
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  // bad
  def apply(name: String, ...): Person =
    if (age < 0 || age > 120) throw new RuntimeException("age is invalid")
    else                      new Person(name, age, address)

}
```
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  // bad
  def apply(name: String, ...): Person =
    if (age < 0 || age > 120) throw new RuntimeException("age is invalid")
    else                      new Person(name, age, address)

  // better
  def apply2(name: String, ...): Option[Person] =
    if (age < 0 || age > 120) None
    else                      Some(new Person(name, age, address))

}
```
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  // bad
  def apply(name: String, ...): Person =
    if (age < 0 || age > 120) throw new RuntimeException("age is invalid")
    else                      new Person(name, age, address)

  // better
  def apply2(name: String, ...): Option[Person] =
    if (age < 0 || age > 120) None
    else                      Some(new Person(name, age, address))

  // Why not
  def apply3(name: String, ...): Either[RuntimeException, Person] =
    if (age < 0 || age > 120) Left(new RuntimeException("age is invalid"))
    else                      Right(new Person(name, age, address))

}
```
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  // bad
  def apply(name: String, ...): Person =
    if (age < 0 || age > 120) throw new RuntimeException("age is invalid")
    else                      new Person(name, age, address)

  // better
  def apply2(name: String, ...): Option[Person] =
    if (age < 0 || age > 120) None
    else                      Some(new Person(name, age, address))

  // Why not
  def apply3(name: String, ...): Either[RuntimeException, Person] =
    if (age < 0 || age > 120) Left(new RuntimeException("age is invalid"))
    else                      Right(new Person(name, age, address))

  // Even better
  final case class InvalidPersonAge(invalidAge: Int) extends RuntimeException(s"age is invalid: $invalidAge")

  def apply4(name: String, ...): Either[InvalidPersonAge, Person] =
    if (age < 0 || age > 120) Left(InvalidPersonAge(age))
    else                      Right(new Person(name, age, address))

}
```
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  // Even better
  final case class InvalidPersonAge(invalidAge: Int) extends RuntimeException(s"age is invalid: $invalidAge")

  def apply4(name: String, ...): Either[InvalidPersonAge, Person] =
    if (age < 0 || age > 120) Left(InvalidPersonAge(age))
    else                      Right(new Person(name, age, address))

}
```
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {

  // Even better
  final case class InvalidPersonAge(invalidAge: Int) extends RuntimeException(s"age is invalid: $invalidAge")

  def apply4(name: String, ...): Either[InvalidPersonAge, Person] =
    if (age < 0 || age > 120) Left(InvalidPersonAge(age))
    else                      Right(new Person(name, age, address))

  // Holy Grail 🏆 (PCE == PersonCreationException)
  sealed abstract class `PCE`(message: String) extends RuntimeException(message)
  final case class InvalidPersonAge(invalidAge: Int)  extends PCE(s"age is invalid: $invalidAge")
  final case class TooDumbNameException(name: String) extends PCE(s"choosed name is too dumb: $name")
  ...

  def apply🏆(name: String, ...): Either[`PCE`, Person] =
    if (age < 0 || age > 120)        Left(InvalidPersonAge(age))
    else if (name == "Harry Potter") Left(TooDumbNameException(name))
    ...
    else                             Right(new Person(name, age, address))

}
```
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {
  // Holy Grail 🏆 (PCE == PersonCreationException)
  sealed abstract class `PCE`(message: String) extends RuntimeException(message)
  final case class InvalidPersonAge(invalidAge: Int)  extends PCE(s"age is invalid: $invalidAge")
  final case class TooDumbNameException(name: String) extends PCE(s"choosed name is too dumb: $name")
  ...

  def apply🏆(name: String, ...): Either[`PCE`, Person] =
    if (age < 0 || age > 120)        Left(InvalidPersonAge(age))
    else if (name == "Harry Potter") Left(TooDumbNameException(name))
    ...
    else                             Right(new Person(name, age, address))
}
```
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {
  // Holy Grail 🏆 (PCE == PersonCreationException)
  sealed abstract class `PCE`(message: String) extends RuntimeException(message)
  final case class InvalidPersonAge(invalidAge: Int)  extends PCE(s"age is invalid: $invalidAge")
  final case class TooDumbNameException(name: String) extends PCE(s"choosed name is too dumb: $name")
  ...

  def apply🏆(name: String, ...): Either[`PCE`, Person] =
    if (age < 0 || age > 120)        Left(InvalidPersonAge(age))
    else if (name == "Harry Potter") Left(TooDumbNameException(name))
    ...
    else                             Right(new Person(name, age, address))
}
```

What's the problem with throwing exceptions ?

  - Breaks linear execution path
  - Makes methods' signature lie
  - Impossible to know if a method is throwing without reading its code and all the code it calls! .bold[(Takes infinite time)]
  - it's an uncontrolled side effect
---
exclude: true
class: center, middle

# Axiom #1

## With imperative programming, it's impossible to produce a safe and deterministic program in a finite time.

#### It's impossible to know if a method is throwing without reading its code and all the code it calls which takes an infinite time.

.right.small[Jules Ivanic]
---
# 7. Impure FP

```scala
final case class Person(name: String, age: Int, address: String)

object Person {
  // Holy Grail 🏆 (PCE == PersonCreationException)
  sealed abstract class `PCE`(message: String) extends RuntimeException(message)
  final case class InvalidPersonAge(invalidAge: Int)  extends PCE(s"age is invalid: $invalidAge")
  final case class TooDumbNameException(name: String) extends PCE(s"choosed name is too dumb: $name")
  ...

  def apply🏆(name: String, ...): Either[`PCE`, Person] =
    if (age < 0 || age > 120)        Left(InvalidPersonAge(age))
    else if (name == "Harry Potter") Left(TooDumbNameException(name))
    ...
    else                             Right(new Person(name, age, address))
}
```

<br />

Now that we have our `Person` constructor correctly implemented,
let's continue our refactoring by fixing the `PersonRepo` code.
---
# 7. Impure FP

Reminder: Here's the Java code we'll rewrite ...

```java


class PersonRepo {

  private DB dbInstance;

  public PersonRepo(DB dbInstance) {
    this.dbInstance = dbInstance;
  }

  public void savePerson(Person p, GpsPoint point) {
    dbInstance.query(
      "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
      p.name, p.age, p.address, point
    )
  }
}
```
---
# 7. Impure FP

... in ("Java++") Scala

```scala


class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint): Unit =
    dbInstance.query(
      "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
      p.name, p.age, p.address, point
    )

}
```
---
exclude: true
# 7. Impure FP

... in .bold[(blocking synchronous impure FP)] Scala

```scala
import scala.util.Try

class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint): `Try[Unit]` =
    `Try {`
      dbInstance.query(
        "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
        p.name, p.age, p.address, point
      )
    `}`

}
```
---
# 7. Impure FP

... in impure FP Scala

```scala
import scala.concurrent.{ExecutionContext, Future, blocking}

class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint)(implicit ex: ExecutionContext): `Future[Unit]` =
    `Future {`
      dbInstance.query(
        "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
        p.name, p.age, p.address, point
      )
    `}`

}
```
---
exclude: true
# 7. Impure FP

... in .bold[(.red[non-]blocking .red[a]synchronous impure FP)] Scala

```scala
import scala.concurrent.{ExecutionContext, Future}

class PersonRepo(dbInstance: `AsyncNIODB`) {

  def savePerson(p: Person, point: GpsPoint)(implicit ex: ExecutionContext): `Future[Unit]` =
    dbInstance.query(
      "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
      p.name, p.age, p.address, point
    )

}
```
---
# 7. Impure FP

Now, let's do quickly the same thing for the `GoogleService`.

Reminder: Here's the Java code we'll rewrite ...

```java


class GoogleService {

  private final HttpClient httpClient;

  public GoogleService(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public GpsPoint geocode(String address) {
    String res =
      httpClient
        .get("https://api.google.com/geocode/address")
        .body("{ \"address\": \"" + address + "\" }")
        .execute();

    return parse(res);
  }
}
```
---
# 7. Impure FP

<br />

... in impure FP Scala

```scala
import scala.concurrent.{ExecutionContext, Future}

class GoogleService(httpClient: HttpClient) {

  // 'map' signature: Future[A].map[B](f: A => B): Future[B]

  def geocode(address: String)(implicit ex: ExecutionContext): `Future[GpsPoint]` =
    `Future {`
      httpClient
        .get("https://api.google.com/geocode/address")
        .body("{ \"address\": \"" + address + "\" }")
        .execute()
    `}`
    `.map(res: String => parse(res))`

}
```
---
exclude: true
# 7. Impure FP

<br />

... in impure FP Scala


```scala
import scala.concurrent.{ExecutionContext, Future}

class GoogleService(httpClient: HttpClient) {

  // 'map' signature: Future[A].map[B](f: A => B): Future[B]

  def geocode(address: String)(implicit ex: ExecutionContext): Future[GpsPoint] =
    Future {
      httpClient
        .get("https://api.google.com/geocode/address")
        .body("{ \"address\": \"" + address + "\" }")
        .execute()
    }
    `.map(parse)`  // 'parse' signature: String => GpsPoint (I'm assuming that parsing will never fail)



// Side note: A simple and interesting exercice for beginners could be to rewrite this code
//  with a 'parse' function which have the following signature: String => Either[ParsingError, GpsPoint]
// 😉

}
```
---
# 7. Impure FP

Finally, let's rewrite our `Server` 'createPerson' method.

Here's the Java version we will rewrite ...

```java
@Put("/person")
public HttpResponse createPerson(@Body Person person) {

  GpsPoint point = geocoder.geocode(person.address);

  repo.savePerson(person, point);

  return HttpResponse.Created("Done 👍");
}
```
---
# 7. Impure FP

<br />

... in impure FP Scala

```scala
@Put("/person")
def createPerson(`json: Json`)(implicit ec: ExecutionContext): `Future[HttpResponse]` = {

  ...

}
```
---
# 7. Impure FP

<br />

... in impure FP Scala

```scala
@Put("/person")
def createPerson(json: Json)(implicit ec: ExecutionContext): Future[HttpResponse] = {

  // 'flatMap' signature: Future[A].flatMap[B](f: A => Future[B]): Future[B]
  // 'map' signature:     Future[A].map[B](f: A => B): Future[B]

  def save(person: Person): Future[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  ...

}
```
---
# 7. Impure FP

<br />

... in impure FP Scala

```scala
@Put("/person")
def createPerson(json: Json)(implicit ec: ExecutionContext): Future[HttpResponse] = {

  // 'flatMap' signature: Future[A].flatMap[B](f: A => Future[B]): Future[B]

  def save(person: Person): Future[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  ...
}
```
---
# 7. Impure FP

<br />

... in impure FP Scala

```scala
@Put("/person")
def createPerson(json: Json)(implicit ec: ExecutionContext): Future[HttpResponse] = {

  // 'flatMap' signature: Future[A].flatMap[B](f: A => Future[B]): Future[B]

  def save(person: Person): Future[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  val parsed: Either[PCE, Person] = JSON.parse[Person](json)

  ...

}
```
---
# 7. Impure FP

<br />

... in impure FP Scala

```scala
@Put("/person")
def createPerson(json: Json)(implicit ec: ExecutionContext): Future[HttpResponse] = {

  // 'flatMap' signature: Future[A].flatMap[B](f: A => Future[B]): Future[B]

  def save(person: Person): Future[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  val parsed: Either[PCE, Person] = JSON.parse[Person](json)

  parsed match {
    case Left(InvalidPersonAge(age))      => Future.successful(HttpResponse.BadRequest(s"Invalid age: $age"))
    case Left(TooDumbNameException(name)) => Future.successful(HttpResponse.BadRequest(s"Invalid name: $name"))
    ...
    case Right(person)                    => save(person).fold(_ => internalError, _ => created)
  }
}
```

TOTO

---
# 7. Impure FP

.bold[Now, let's get back to our primary example.]
---
# 7. Impure FP

.bold[Now, let's get back to our primary example:]

impure FP Scala

```scala
import scala.concurrent.{ExecutionContext, Future}

class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint)(implicit ex: ExecutionContext): Future[Unit] =
    Future {
      dbInstance.query(
        "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
        p.name, p.age, p.address, point
      )
    }

}
```
---
# 7. Impure FP

.bold[Now, let's get back to our primary example:]

impure FP Scala

```scala
import scala.concurrent.{ExecutionContext, Future}

class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint)(implicit ex: ExecutionContext): Future[Unit] =
    Future {
      dbInstance.query(
        "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
        p.name, p.age, p.address, point
      )
    }

}
```

.bold[Why is this code not pure ?]
---
# 7. Impure FP

.bold[Now, let's get back to our primary example:]

impure FP Scala

```scala
import scala.concurrent.{ExecutionContext, Future}

class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint)(implicit ex: ExecutionContext): `Future[Unit]` =
    Future {
      dbInstance.query(
        "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
        p.name, p.age, p.address, point
      )
    }

}
```

.bold[Why is this code not pure ?]

The problem comes from the `Future`!
---
# 7. Impure FP

.bold[Why is the previous code not pure ?] => The problem comes from the `Future`.

```scala
// This:
def twoMissiles: (Future[Unit], Future[Unit]) = ( Future { launchMissile() }, Future { launchMissile() } )
```
---
# 7. Impure FP

.bold[Why is the previous code not pure ?] => The problem comes from the `Future`.

```scala
// This:
def twoMissiles: (Future[Unit], Future[Unit]) = ( Future { launchMissile() }, Future { launchMissile() } )

scala> twoMissiles
🚀
🚀
```
---
# 7. Impure FP

.bold[Why is the previous code not pure ?] => The problem comes from the `Future`.

```scala
// This:
def twoMissiles: (Future[Unit], Future[Unit]) = ( Future { launchMissile() }, Future { launchMissile() } )

scala> twoMissiles
🚀
🚀

scala> twoMissiles
🚀
🚀
```
---
# 7. Impure FP

.bold[Why is the previous code not pure ?] => The problem comes from the `Future`.

```scala
// This:
def twoMissiles: (Future[Unit], Future[Unit]) = ( Future { launchMissile() }, Future { launchMissile() } )

scala> twoMissiles
🚀
🚀

scala> twoMissiles
🚀
🚀

// is not equivalent to this while it should be if pure:
lazy val oneMissile: Future[Unit]             = Future { launchMissile() }
def twoMissiles: (Future[Unit], Future[Unit]) = (oneMissile, oneMissile)
```
---
# 7. Impure FP

.bold[Why is the previous code not pure ?] => The problem comes from the `Future`.

```scala
// This:
def twoMissiles: (Future[Unit], Future[Unit]) = ( Future { launchMissile() }, Future { launchMissile() } )

scala> twoMissiles
🚀
🚀

scala> twoMissiles
🚀
🚀

// is not equivalent to this while it should be if pure:
lazy val oneMissile: Future[Unit]             = Future { launchMissile() }
def twoMissiles: (Future[Unit], Future[Unit]) = (oneMissile, oneMissile)

scala> twoMissiles
🚀
```
---
# 7. Impure FP

.bold[Why is the previous code not pure ?] => The problem comes from the `Future`.

```scala
// This:
def twoMissiles: (Future[Unit], Future[Unit]) = ( Future { launchMissile() }, Future { launchMissile() } )

scala> twoMissiles
🚀
🚀

scala> twoMissiles
🚀
🚀

// is not equivalent to this while it should be if pure:
lazy val oneMissile: Future[Unit]             = Future { launchMissile() }
def twoMissiles: (Future[Unit], Future[Unit]) = (oneMissile, oneMissile)

scala> twoMissiles
🚀

scala> twoMissiles
∅
```
---
# 7. Impure FP

.bold[Why is the previous code not pure ?] => The problem comes from the `Future`.

Complete explanation of the problem:

https://stackoverflow.com/questions/27454798/is-future-in-scala-a-monad/27467037#27467037
---
class: center, middle

# 8. Pure FP
---
# 8. Pure FP

Now that we know what a pure function is and we know that `Future`s doesn't respect pure function laws.

Let's purify our code !
---
# 8. Pure FP

Now that we know what a pure function is and we know that `Future`s doesn't respect pure function laws.

Let's purify our code !

.bold[But how ?]
---
# 8. Pure FP

Now that we know what a pure function is and we know that `Future`s doesn't respect pure function laws.

Let's purify our code !

.bold[But how ?]

Here's the trick FP devs found to purify everything:

.bold[They don't execute anything!]
---
# 8. Pure FP

Now that we know what a pure function is and we know that `Future`s doesn't respect pure function laws.

Let's purify our code !

.bold[But how ?]

Here's the trick FP devs found to purify everything:

.bold[They don't execute anything!]

```scala
final case class Task[A](a: () => A)
```
```scala
val t: Task[GpsPoint] = Task(syncGeocoder.geocode(person.address))
```
---
# 8. Pure FP

Now that we know what a pure function is and we know that `Future`s doesn't respect pure function laws.

Let's purify our code !

.bold[But how ?]

Here's the trick FP devs found to purify everything:

.bold[They don't execute anything!]

```scala
final case class Task[A](a: () => A)
```
```scala
val t: Task[GpsPoint] = Task(syncGeocoder.geocode(person.address))

// is very different than:

val f: Future[GpsPoint] = Future(syncGeocoder.geocode(person.address))
```
---
# 8. Pure FP

Now that we know what a pure function is and we know that `Future`s doesn't respect pure function laws.

Let's purify our code !

.bold[But how ?]

Here's the trick FP devs found to purify everything:

.bold[They don't execute anything!]

```scala
final case class Task[A](a: () => A)
```

```scala
val t: Task[GpsPoint] = Task(syncGeocoder.geocode(person.address))      // lazy
// t: Task[GpsPoint] = Task(a = <function0>)      // lazy

// is very different than:

val f: Future[GpsPoint] = Future(syncGeocoder.geocode(person.address))  // eager
// f: Future[GpsPoint] = Future(Success(GpsPoint(12.23,32.21)))
```
---
# 8. Pure FP

Now that we know what a pure function is and we know that `Future`s doesn't respect pure function laws.

Let's purify our code !

.bold[But how ?]

Here's the trick FP devs found to purify everything:

.bold[They don't execute anything!]

```scala
final case class Task[A](a: () => A)
```

```scala
val t: Task[GpsPoint] = Task(syncGeocoder.geocode(person.address))      // lazy
// t: Task[GpsPoint] = Task(a = <function0>)      // lazy

// is very different than:

val f: Future[GpsPoint] = Future(syncGeocoder.geocode(person.address))  // eager
// f: Future[GpsPoint] = Future(Success(GpsPoint(12.23,32.21)))  // eager
Await.result(f, 10.seconds)
// res0: GpsPoint = GpsPoint(lat = 12.23, long = 32.21)
```
---
# 8. Pure FP

So, let's rewrite our impure FP Scala code.
---
# 8. Pure FP

So, let's rewrite our impure FP Scala code.

```scala
final case class Person(name: String, age: Int, address: String)

object Person {
  // Holy Grail 🏆 (PCE == PersonCreationException)
  sealed abstract class `PCE`(message: String) extends RuntimeException(message)
  final case class InvalidPersonAge(invalidAge: Int)  extends PCE(s"age is invalid: $invalidAge")
  final case class TooDumbNameException(name: String) extends PCE(s"choosed name is too dumb: $name")
  ...

  def apply🏆(name: String, ...): Either[`PCE`, Person] =
    if (age < 0 || age > 120)        Left(InvalidPersonAge(age))
    else if (name == "Harry Potter") Left(TooDumbNameException(name))
    ...
    else                             Right(new Person(name, age, address))
}
```

Our `Person` code is already pure. Next!
---
# 8. Pure FP

Here's our `PersonRepo` impure FP code ...

```scala
import scala.concurrent.{ExecutionContext, Future}

class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint)(implicit ex: ExecutionContext): Future[Unit] =
    Future {
      dbInstance.query(
        "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
        p.name, p.age, p.address, point
      )
    }

}
```
---
# 8. Pure FP

... now pure.

```scala
import monix.eval.Task

class PersonRepo(dbInstance: DB) {

  def savePerson(p: Person, point: GpsPoint): `Task[Unit]` =
    `Task` {
      dbInstance.query(
        "INSERT INTO PERSONS (name, age, address, gpsPoint) VALUES (?, ?, ?, ?)",
        p.name, p.age, p.address, point
      )
    }

}
```
---
# 8. Pure FP

Here's our `GoogleService` impure FP code ...

```scala
import scala.concurrent.{ExecutionContext, Future}

class GoogleService(httpClient: HttpClient) {

  def geocode(address: String)(implicit ex: ExecutionContext): Future[GpsPoint] =
    Future {
      httpClient
        .get("https://api.google.com/geocode/address")
        .body("{ \"address\": \"" + address + "\" }")
        .execute()
    }
    .map(res => parse(res))

}
```
---
# 8. Pure FP

... now pure.

```scala
import monix.eval.Task

class GoogleService(httpClient: HttpClient) {

  def geocode(address: String): `Task[GpsPoint]` =
    `Task` {
      httpClient
        .get("https://api.google.com/geocode/address")
        .body("{ \"address\": \"" + address + "\" }")
        .execute()
    }
    .map(res => parse(res))

}
```
---
# 8. Pure FP

And finally, let's purify our `Server` impure code ...

```scala
@Put("/person")
def createPerson(json: Json)(implicit ec: ExecutionContext): Future[HttpResponse] = {

  def save(person: Person): Future[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  val parsed: Either[PCE, Person] = JSON.parse[Person](json)

  parsed match {
    case Left(InvalidPersonAge(age))      => Future.successful(HttpResponse.BadRequest(s"Invalid age: $age"))
    case Left(TooDumbNameException(name)) => Future.successful(HttpResponse.BadRequest(s"Invalid name: $name"))
    ...
    case Right(person)                    => save(person).fold(_ => internalError, _ => created)
  }
}
```
---
# 8. Pure FP

... now pure.

```scala
@Put("/person")
def createPerson(json: Json): `Future[HttpResponse]` = {

  ...

}
```
---
# 8. Pure FP

... now pure.

```scala
@Put("/person")
def createPerson(json: Json): Future[HttpResponse] = {

  def save(person: Person): `Task[Unit]` =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  ...

}
```
---
# 8. Pure FP

... now pure.

```scala
@Put("/person")
def createPerson(json: Json): Future[HttpResponse] = {

  def save(person: Person): Task[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  val parsed: `Task[Either[PCE, Person]]` = `Task.now(JSON.parse[Person](json))`

  ...
}
```
---
# 8. Pure FP

... now pure.

```scala
@Put("/person")
def createPerson(json: Json): Future[HttpResponse] = {

  def save(person: Person): Task[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  val parsed: Task[Either[PCE, Person]] = Task.now(JSON.parse[Person](json))

  parsed`.flatMap(`_ match {
    case Left(InvalidPersonAge(age))      => `Task.now`(HttpResponse.BadRequest(s"Invalid age: $age"))
    case Left(TooDumbNameException(name)) => `Task.now`(HttpResponse.BadRequest(s"Invalid name: $name"))
    ...
    case Right(person)                    => save(person).fold(_ => internalError, _ => created)
  }`)`
}
```
---
# 8. Pure FP

... now pure.

```scala
@Put("/person")
def createPerson(json: Json): Future[HttpResponse] = {

  def save(person: Person): Task[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  val parsed: Task[Either[PCE, Person]] = Task.now(JSON.parse[Person](json))

  parsed`.flatMap(`_ match {
    case Left(InvalidPersonAge(age))      => `Task.now`(HttpResponse.BadRequest(s"Invalid age: $age"))
    case Left(TooDumbNameException(name)) => `Task.now`(HttpResponse.BadRequest(s"Invalid name: $name"))
    ...
    case Right(person)                    => save(person).fold(_ => internalError, _ => created)
  }`)`
}
```

🤔
---
# 8. Pure FP

... now pure.

```scala
@Put("/person")
def createPerson(json: Json): Future[HttpResponse] = {
  def save(person: Person): Task[Unit] =
    geocoder
      .geocode(person.address)
      .flatMap(gpsPoint => repo.savePerson(person, gpsPoint))

  def internalError: HttpResponse = HttpResponse.InternalServerError()
  def created: HttpResponse       = HttpResponse.Created("Done 👍")

  val parsed: Task[Either[PCE, Person]] = Task.now(JSON.parse[Person](json))

  `val program: Task[HttpResponse] =`
    parsed`.flatMap(`_ match {
      case Left(InvalidPersonAge(age))      => `Task.now`(HttpResponse.BadRequest(s"Invalid age: $age"))
      case Left(TooDumbNameException(name)) => `Task.now`(HttpResponse.BadRequest(s"Invalid name: $name"))
      ...
      case Right(person)                    => save(person).fold(_ => internalError, _ => created)
    }`)`

  `TaskRuntime.runToFuture(program)`
}
```

Done! 👍😊
---
# 8. Pure FP

The previous `Task` data structure is an implementation of .bold[the IO Monad].

The IO Monad is sometimes named .blue[`IO`], sometimes .blue[`Task`], etc.<br />
It'll depend on your programming language and/or the implementation you choose.

In Scala, there're 3 different implementations:
  - .underlined[Monix], which named it .blue[`Task`]: https://monix.io/
  - .underlined[Cats-Effects], which named it .blue[`IO`]: https://typelevel.org/cats-effect/
  - .underlined[ZIO], which implemented a bifunctor IO Monad named .blue[`ZIO`]: https://zio.dev/
---
# 8. Pure FP

Now, you're able to understand the signature of the Haskell `main` function:

```haskell
main :: IO ()     -- '()' == 'Unit' in Scala. So, the equivalent signature in Scala is `IO[Unit]`
```
---
# 8. Pure FP

Now, you're able to understand the signature of the Haskell `main` function:

```haskell
main :: IO ()     -- '()' == 'Unit' in Scala. So, the equivalent signature in Scala is `IO[Unit]`
```

And also see why Scala is not a pure programming language:
```scala
def main(args: Array[String]): Unit
```
---
class: center, middle

# Conclusion
---
# Conclusion

<br />
<br />
<br />
<br />

.center[
### FP helps me to write declarative code. .small[(`.map`, `.filter`, etc.)]
]
---
# Conclusion

<br />
<br />
<br />
<br />

.center[
### FP helps me to write declarative code. .small[(`.map`, `.filter`, etc.)]

### Pure FP helps me to write composable code. .small[(Referential transparency)]
]
---
# Conclusion

<br />
<br />
<br />
<br />

.center[
### FP helps me to write declarative code. .small[(`.map`, `.filter`, etc.)]

### Pure FP helps me to write composable code. .small[(Referential transparency)]

## Give it a try!
]
---
class: center, middle

# Thanks!

Slides at https://guizmaii.github.io/LilleFP

Code of the slides at https://github.com/guizmaii/LilleFP

## Questions?
