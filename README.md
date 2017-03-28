#QUICK GITHUB CHEAT SHEET

###How to make new branches to add a Feature/ Fix a bug etc

In order to add a feature, go onto GitHub and make sure it is marked in our issues. You can assign a particular issue to yourself or just add it to the list so someone else can work on it at some point.

On your local machine, make sure you are on the master branch and run the following code:

```
git checkout -b <NAME OF YOUR NEW BRANCH>
```

And then to push the branch so everyone else can access it type:
```
git push origin <NAME OF YOUR NEW BRANCH>
```

This will generate a new local branch. Now you can work on it (or at least make a single change.)

Then run:

```
git add <FILE YOU CHANGED>
```

Alternatively you can use 'git add --all' to add all files to your working directory. Now run:

```
git commit -m "Comment that describes what I did in this change"
```

and then:

```
git push --set-upstream origin <NAME OF YOUR BRANCH>
```


Alternatively you can create a branch in GitHub online.


###What to avoid

Never run git commands you do not know. Always do a quick search first or ask. This applies in particular to commands such as 'git clean'
