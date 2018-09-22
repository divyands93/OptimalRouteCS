# OptimalRouteCS
Case study for optimal Route


Assumptions

Given graph is undirected graph. graph has vertices and edges 

vertices has vertexName

Edges have fromVertex, toVertex, weight

POST url - http:localhost:8085/route Sample data- {"vertexes":[{"vertexName":"A"},{"vertexName":"B"}],"edges":[{"weight":3,"fromVertex":"A","toVertex":"B"},{"weight":3,"fromVertex":"B","toVertex":"A"}]}

GET url - http:localhost:8085/getroute url - http:localhost:8085/getShortestRoute/{StartVertex}/{EndVertex}

PUT url -/route Sample data - { "weight": 15, "fromVertex": "B", "toVertex": "A" }
