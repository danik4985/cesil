# CESIL
The one-and-only bri'ish [programming language](https://en.wikipedia.org/wiki/CESIL)

When I first heard of CESIL, I was like *what the fuck*. And I still am like *what the fuck* But I decided I will practice my kotlin skills on making a cesil intepretor in it, since the only other one I could found is in 🤮️p*thon🤮️.
I tried to make this as authentic as possible, feel free to report bugs.

> Im not sure how it worked in original cesil, but from the wiki article I understood that (in program section) all positive numbers must start with `+` and negatives with `-`, and thats how it works in my implementation.

An CESIL example:
```cesil
        LOAD    +0
LOOP    STORE   TOTAL
        IN
        JINEG   DONE
        ADD     TOTAL
        JUMP    LOOP

DONE    PRINT   "The total is: "
        LOAD    TOTAL
        OUT
        LINE
        HALT

%
1
2
3
-1
*
```
This example safely outputs `The total is: 6`

## Usage
`java -jar <Path to the jar you download from releases> <Path to your cesil source file>`

### Usage example
```shell
# Run the source.ces file
java -jar Cesil.jar "source.ces"
```

### Creating an alias for cesil
If you are a bash user, you can create an alias, so that you can type eg. `cesil` instead of `java -jar Cesil.jar`
You can do this easily:
```shell
# Use this command
echo 'alias cesil="java -jar <full path to the jar>"' >> ~/.bashrc
```

