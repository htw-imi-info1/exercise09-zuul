.RECIPEPREFIX = -
.PHONY = open, clean, add-java

open:
- open your-zuul/package.bluej

clean:
- rm **/*.class

add-java:
- git add **/*.java
- git status
