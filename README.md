# MinTrianglePath

This command line application accepts a number of lines containing space separated (positive) integers which together represent a triangle of numbers. 
The application then calculates the minimum triangle path, i.e. the path who's summation is the least from all other paths.

### Compiling and Executing:
1. Download source code.

2. `cd {code_location}/src/`
3. `javac Main.java`
4.
~~~~
cat << EOF | java Main
> {line 1}
> {line 2}
> ...
> EOF
~~~~

where `{line1}`, `{line2}` etc... should be substituted with space separated integer values. Example:
~~~~
cat << EOF | java Main 
7
6 3
3 8 5
11 2 10 9
EOF
~~~~
