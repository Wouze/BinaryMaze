# Binary-maze
A player wants to escape a maze where at most two options are available at each step: go
straight or turn. This maze can be represented by a binary tree where the data is a character
that can take four values: ’B’ for begin (only at the root), ’S’ for go straight, ’T’ for turn, or
’X’ meaning this is an exit. Exits are located at leaf nodes only, but not all leaf nodes are
exits, they could be dead ends.