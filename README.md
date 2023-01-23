Percolation:

Percolation is a scientific model that is used to analyze the connectivity of systems. For example, it can be usedto analyze if a porous landscape with water on the surface will eventually allow the water to drain through to thebottom. It can be used to analyze if oil would be able to reach the surface in a similar manner. The idea of themodel is to analyze what conditions are necessary for the system to percolate (i.e. let the water or oil through).The current assignment will allow students to apply the union-find data structure to solve this problem. Thesystem will be represented as aN-by-Ngrid where each cell can be in one of 3 states: blocked (black), open(white) or full (blue). A grid where percolation has been achieved will have a path of full cells from the surfaceto the bottom

Tasks:
The current project will be divided into 3 programming tasks and an analysis phase that will require codesimulation, experimental evaluation, and discussion of the results. It is expected that students will use thestandard libraryprovided by the authors of the course textbook, along with the suggested implementations forunion-find data structures in Algorithm 1.5 (Chapter 1). The standard library JAR file can be directly accessedhereand basic instructions on how to execute programs using it arehere

Programming Tasks To Complete:
Create a subclass of PercolationDFS named PercolationDFSFast.
This class is a modification of the brute-force PercolationDFS model that uses depth first search and implements the IPercolate interface. Your PercolationDFSFast will have a different implementation of the method updateOnOpen to improve the efficiency of the simulation and also throw appropriate exceptions if methods are called with parameters that are not in bounds.
Create a class PercolationUF that implements the IPercolate interface that can that can use any union-find object that implements IUnionFind (e.g., QuickFind.java).
Create a class QuickUWPC that implements the IUnionFind interface to implement union-find quick-union with path compression. 
Create a class PercolationStats that runs several Monte Carlo simulations on an  grid using classes that implement the IPercolate interface, and reports statistics about the percolation threshold and how long it takes the simulations to run on average.

Analysis to Complete
You will need to run the simulation implemented in PercolationStats for several different IPercolate implementations as explained in the analysis section below
