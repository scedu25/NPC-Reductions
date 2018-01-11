Our approach to this assignment would be for one partner to create a solveClique class that finds all of the cliques in the graph and then returns the maximum clique. Then the other partner would make a solve3CNF class that takes a CNF statement, and translates it into a clique problem. Then the solveClique class can find the maximum clique of that graph which would lead us to our assignments of True and False for the CNF. The same would be done similarly to the ISET problem. This reduction is possible because a clique problem, CNF, and ISET are all NP-Complete problems. More specifically our 3CNF approach was to read in the CNF assignments from the text file and add them to an arraylist. Then our program will traverse through the arraylist and apply rules that allow us to draw edges to different nodes, thus making an adjacency matrix. Then this matrix is sent to the solveClique class to find the maximum clique that will also output the true/false assignments. The solveClique class uses a brute force or backtracking approach for finding all cliques of a graph and eventually returning the largest one. We did run into a slight problem during this assignment. When the solve3CNF creates an adjacency matrix and is sent to the solveClique class, the solveClique method has an extremely long run time. This is because there are so many possible graphs that could be created from the text file that was provided for this assignment. We are sure that our program does work, because the first 15 assignments complete quickly and correctly, but the bigger graphs after that begin to have problems. You will be able to analyze and understand this from our outputs below. 
Output examples: 
Compilation
Joshuas-MacBook-Pro:program1 josh$ ls
Graph.java		graphs16.txt		solveISET.java
Vertex.java		solve3CNF.java
cnfs16.txt		solveClique.java
Joshuas-MacBook-Pro:program1 josh$ javac Graph.java
Joshuas-MacBook-Pro:program1 josh$ javac Vertex.java
jJoshuas-MacBook-Pro:program1 josh$ javac solveClique.java
Joshuas-MacBook-Pro:program1 josh$ javac solveISET.java
Joshuas-MacBook-Pro:program1 josh$ javac solve3CNF.java


solveClique.java

Joshuas-MacBook-Pro:program1 josh$ java solveClique
* Max Cliques of graphs in graphs16.txt
    (|V|,|E|) Cliques (size, ms used)
G1 (2,0) {0} (size=1, 1 ms)
G2 (2,1) {0,1} (size=2, 0 ms)
G3 (4,4) {2,1,3} (size=3, 0 ms)
G4 (4,5) {0,1,3} (size=3, 0 ms)
G5 (6,5) {0,2} (size=2, 0 ms)
G6 (6,12) {0,1,2,4} (size=4, 0 ms)
G7 (8,10) {2,1} (size=2, 0 ms)
G8 (8,16) {2,3,5,6} (size=4, 0 ms)
G9 (10,19) {2,1,4,6} (size=4, 0 ms)
G10 (10,30) {0,8,4,6,9} (size=5, 0 ms)
G11 (12,25) {2,1,4,10} (size=4, 1 ms)
G12 (12,41) {0,4,3,5,8,11} (size=6, 1 ms)
G13 (14,34) {2,4,7,12} (size=4, 0 ms)
G14 (14,68) {0,3,2,4,5,12,13} (size=7, 1 ms)
G15 (16,43) {0,2,6} (size=3, 0 ms)
G16 (16,79) {2,1,4,5,8,11,14} (size=7, 1 ms)
G17 (18,64) {2,7,17,16} (size=4, 1 ms)
G18 (18,108) {10,1,3,5,9,11,14} (size=7, 1 ms)
G19 (20,59) {4,8,5,13} (size=4, 0 ms)
G20 (20,130) {8,1,5,9,10,11,19,15} (size=8, 1 ms)
G21 (22,81) {0,1,3,18} (size=4, 1 ms)
G22 (22,158) {8,1,7,9,17,12,18,21} (size=8, 2 ms)
G23 (24,96) {0,5,7,10} (size=4, 0 ms)
G24 (24,204) {0,1,2,3,4,5,8,22} (size=8, 4 ms)
G25 (26,109) {2,14,7,18} (size=4, 0 ms)
G26 (26,222) {2,7,10,14,15,16,17,22} (size=8, 6 ms)
G27 (28,131) {4,9,11,25,19} (size=5, 1 ms)
G28 (28,265) {2,3,10,6,8,17,21,24} (size=8, 6 ms)
G29 (30,149) {0,12,11,15,25} (size=5, 0 ms)
G30 (30,320) {0,1,3,4,6,9,11,23,24} (size=9, 11 ms)
G31 (32,157) {0,10,5,9,13} (size=5, 0 ms)
G32 (32,355) {0,2,11,10,12,17,23,24,28} (size=9, 10 ms)
G33 (34,190) {8,26,32,21,31} (size=5, 0 ms)
G34 (34,388) {0,1,2,7,11,14,23,24,27} (size=9, 8 ms)
G35 (36,241) {0,5,6,23,22} (size=5, 0 ms)
G36 (36,439) {2,11,13,14,12,15,16,18,20,22,32} (size=11, 18 ms)
G37 (38,224) {0,7,6,22,29} (size=5, 0 ms)
G38 (38,474) {2,4,3,7,9,10,15,18,19,21} (size=10, 12 ms)
G39 (40,261) {10,1,19,21,32,36} (size=6, 0 ms)
G40 (40,530) {0,2,11,13,19,18,30,35,39} (size=9, 10 ms)
G41 (42,320) {0,1,15,8,19,25,41} (size=7, 1 ms)
G42 (42,599) {0,1,2,6,15,8,13,22,25,34} (size=10, 27 ms)
G43 (44,332) {2,6,29,15,25,42} (size=6, 0 ms)
G44 (44,675) {0,9,11,19,24,27,28,30,34,38,42} (size=11, 26 ms)
G45 (46,373) {0,5,21,36,45} (size=5, 1 ms)
G46 (46,723) {2,10,5,9,15,19,21,24,32,33} (size=10, 25 ms)
G47 (48,413) {0,39,2,25,34} (size=5, 0 ms)
G48 (48,784) {0,12,18,11,20,26,32,29,33,35,42,47} (size=12, 42 ms)
G49 (50,413) {0,10,14,21,26} (size=5, 0 ms)
G50 (50,852) {8,7,5,17,16,23,21,29,34,38,41,48} (size=12, 60 ms)
G51 (52,478) {0,15,38,17,27} (size=5, 1 ms)
G52 (52,889) {0,3,9,21,28,24,36,37,38,42,47} (size=11, 58 ms)
G53 (54,506) {2,9,8,19,35,50} (size=6, 1 ms)
G54 (54,1005) {0,1,23,3,6,13,22,24,32,33,34} (size=11, 81 ms)
G55 (56,522) {2,3,4,6,27,35,50} (size=7, 1 ms)
G56 (56,1054) {0,4,5,11,15,28,25,47,49,52,55} (size=11, 60 ms)
G57 (58,567) {30,11,31,27,41,45} (size=6, 0 ms)
G58 (58,1158) {2,9,6,13,17,36,19,21,35,49,50,57} (size=12, 117 ms)
G59 (60,606) {6,21,20,33,29,37} (size=6, 1 ms)
G60 (60,1228) {0,7,15,4,14,17,20,24,33,34,47,55} (size=12, 167 ms)






solve3CNF.java

Joshuas-MacBook-Pro:program1 josh$ java solve3CNF 
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
	at solve3CNF.main(solve3CNF.java:37)
Joshuas-MacBook-Pro:program1 josh$ java solve3CNF "cnfs16.txt"
3CNF No.1:[n = 3 k = 9]  No 9-clique; no solution (18 ms)
3CNF No.2:[n = 3 k = 8]  Assignments: [A1=T A2=F A3=F ] (25 ms)
3CNF No.3:[n = 3 k = 9]  No 9-clique; no solution (31 ms)
3CNF No.4:[n = 3 k = 9]  Assignments: [A1=F A2=F A3=F ] (40 ms)
3CNF No.5:[n = 3 k = 8]  Assignments: [A1=T A2=T A3=T ] (43 ms)
3CNF No.6:[n = 3 k = 11]  Assignments: [A1=T A2=T A3=F ] (94 ms)
3CNF No.7:[n = 4 k = 10]  Assignments: [A1=F A2=F A3=F A4=T ] (118 ms)
3CNF No.8:[n = 4 k = 12]  No 12-clique; no solution (197 ms)
3CNF No.9:[n = 4 k = 12]  No 12-clique; no solution (294 ms)
3CNF No.10:[n = 4 k = 11]  Assignments: [A1=T A2=F A3=F A4=F ] (350 ms)
3CNF No.11:[n = 5 k = 13]  Assignments: [A1=T A2=T A3=T A4=T A5=T ] (924 ms)
3CNF No.12:[n = 5 k = 15]  No 15-clique; no solution (3451 ms)
3CNF No.13:[n = 5 k = 15]  No 15-clique; no solution (4745 ms)
3CNF No.14:[n = 5 k = 15]  Assignments: [A1=F A2=F A3=F A4=F A5=T ] (11435 ms)



solveISET.java

^CJoshuas-MacBook-Pro:program1 josh$ java solveISET 
* Max Independent Sets in graphs in graphs16.txt : graphs16.txt  (reduced to K-Clique) *
    (|V|,|E|) Independent Set (size, ms used)
G1 (2,0) {0,1} (size=2, 1 ms)
G2 (2,1) {0} (size=1, 0 ms)
G3 (4,4) {0,1} (size=2, 0 ms)
G4 (4,5) {0,2} (size=2, 0 ms)
G5 (6,5) {0,1,4} (size=3, 0 ms)
G6 (6,12) {2,3} (size=2, 0 ms)
G7 (8,10) {0,1,3,4} (size=4, 0 ms)
G8 (8,16) {0,1,5} (size=3, 0 ms)
G9 (10,19) {0,1,5,8} (size=4, 1 ms)
G10 (10,30) {0,1,3} (size=3, 0 ms)
G11 (12,25) {8,1,3,5,7,11} (size=6, 1 ms)
G12 (12,41) {6,7,8,10} (size=4, 0 ms)
G13 (14,34) {0,1,2,3,8} (size=5, 1 ms)
G14 (14,68) {4,1,9} (size=3, 0 ms)
G15 (16,43) {0,1,4,5,12,13} (size=6, 1 ms)
G16 (16,79) {0,1,3,15} (size=4, 0 ms)
G17 (18,64) {0,3,16,6,14} (size=5, 1 ms)
G18 (18,108) {0,11,13} (size=3, 0 ms)
G19 (20,59) {0,1,3,6,13,15} (size=6, 2 ms)
G20 (20,130) {0,3,8,17,18} (size=5, 1 ms)
G21 (22,81) {0,5,11,7,12,14,20} (size=7, 1 ms)
G22 (22,158) {2,1,3,15} (size=4, 0 ms)
G23 (24,96) {0,1,9,4,11,20,23} (size=7, 2 ms)
G24 (24,204) {6,12,8,13} (size=4, 0 ms)
G25 (26,109) {0,1,7,6,9,10,19,22} (size=8, 1 ms)
G26 (26,222) {4,20,15,18} (size=4, 1 ms)
G27 (28,131) {2,1,4,5,17,16,18,26} (size=8, 2 ms)
G28 (28,265) {0,2,27,13} (size=4, 0 ms)
G29 (30,149) {8,1,3,5,7,11,16,18,23} (size=9, 4 ms)
G30 (30,320) {6,8,17,13,20} (size=5, 0 ms)
G31 (32,157) {2,1,3,5,14,28,23,30,31} (size=9, 8 ms)
G32 (32,355) {4,11,3,18} (size=4, 1 ms)
G33 (34,190) {0,1,2,14,12,24,32,33} (size=8, 7 ms)
G34 (34,388) {22,32,3,17,33} (size=5, 0 ms)
G35 (36,241) {4,1,3,5,10,13,20,32,33} (size=9, 7 ms)
G36 (36,439) {0,29,13,31} (size=4, 1 ms)
G37 (38,224) {0,3,5,9,13,14,19,23,24,25} (size=10, 17 ms)
G38 (38,474) {0,5,4,24,28} (size=5, 0 ms)
G39 (40,261) {6,22,11,15,27,29,30,37,38,39} (size=10, 22 ms)
G40 (40,530) {0,8,21,17,34} (size=5, 0 ms)
G41 (42,320) {10,5,3,7,21,25,22,27,30,39} (size=10, 13 ms)
G42 (42,599) {4,8,20,24,39} (size=5, 1 ms)
G43 (44,332) {10,1,13,17,16,19,37,38,40,42} (size=10, 16 ms)
G44 (44,675) {6,24,31,22,32} (size=5, 0 ms)
G45 (46,373) {8,3,7,9,12,15,18,31,34,42} (size=10, 14 ms)
G46 (46,723) {2,13,3,28,18} (size=5, 1 ms)
G47 (48,413) {4,5,10,24,29,17,26,30,39} (size=9, 13 ms)
G48 (48,784) {0,25,36,15,44} (size=5, 0 ms)
G49 (50,413) {0,1,2,5,6,12,15,20,37,45} (size=10, 25 ms)
G50 (50,852) {0,6,7,15,30} (size=5, 1 ms)
G51 (52,478) {10,1,15,12,14,18,19,25,41,50} (size=10, 18 ms)
G52 (52,889) {2,17,31,36,44} (size=5, 1 ms)
G53 (54,506) {0,2,10,14,16,15,17,27,33,52} (size=10, 29 ms)
G54 (54,1005) {4,10,35,36,27} (size=5, 1 ms)
G55 (56,522) {2,1,5,8,16,15,36,31,40,42,51} (size=11, 60 ms)
G56 (56,1054) {2,7,9,19,44} (size=5, 1 ms)
G57 (58,567) {2,1,8,16,14,19,18,25,23,41} (size=10, 37 ms)
G58 (58,1158) {12,1,24,16,22,36} (size=6, 1 ms)
G59 (60,606) {0,15,5,21,34,38,41,46,47,49,55} (size=11, 62 ms)
G60 (60,1228) {42,7,11,21,46,41} (size=6, 1 ms)
***
