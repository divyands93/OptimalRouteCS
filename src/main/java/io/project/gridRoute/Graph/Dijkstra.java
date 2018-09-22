package io.project.gridRoute.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

    private Map<Vertex,DistanceAndPrevVertex> calcGrid = null;

    public void printShortestPath(Graph g, Vertex begin, Vertex end) {
        calcGrid = new HashMap();
        for(Vertex v : g.getVertexes()) {
            calcGrid.put(v,new DistanceAndPrevVertex());
        }
        if(begin != null) {
            calcGrid.get(begin).setDis(0);
            begin.setVisited();
            List<Edge> edges = begin.getToEdges();
            this.loopPath(edges);
        };

        Stack<Vertex> path = new Stack<>();
        while(!end.equals(begin)) {
            path.push(end);
            end = calcGrid.get(end).getPrevV();
        }
        path.push(begin);
        while(!path.empty()) {
            System.out.println(path.pop().getVertexName());
        }
    }

    private void loopPath(List<Edge> edges) {
        if(edges != null && edges.size() > 0) {
            for(Edge e : edges) {
                if(!e.getToVertex().isVisited()) {
                	System.out.println("hi"+calcGrid.get(e.getToVertex()));
                    if(calcGrid.get(e.getToVertex()).getDis() == null
                       || calcGrid.get(e.getToVertex()).getDis()
                          > (e.getWeight() + calcGrid.get(e.getFromVertex()).getDis())){
                        calcGrid.get(e.getToVertex()).setDis(e.getWeight() + calcGrid.get(e.getFromVertex()).getDis());
                        calcGrid.get(e.getToVertex()).setPrevV(e.getFromVertex());
                    }
                }
            }
            Vertex minV = getMinVertex(calcGrid);
            if(minV != null) {
                minV.setVisited();
                loopPath(minV.getToEdges());
            }
        }
    }

    private Vertex getMinVertex(Map<Vertex,DistanceAndPrevVertex> calcGrid) {
        int minDis = Integer.MAX_VALUE;
        Vertex v = null;
        for(Map.Entry<Vertex,DistanceAndPrevVertex> e : calcGrid.entrySet()) {
            if(!e.getKey().isVisited()) {
                if(e.getValue().getDis() != null && e.getValue().getDis() < minDis) {
                    minDis = e.getValue().getDis();
                    v = e.getKey();
                }
            }
        }
        return v;
    }

    public Vertex getVertexByName(Graph g,String vName) {
        Vertex[] vertexes = g.getVertexes();
        if(null != vertexes) {
            for(Vertex v : vertexes) {
                if(v.getVertexName() != null && v.getVertexName().equals(vName)) {
                    return v;
                }
            }
        }
        return null;
    }

    private class DistanceAndPrevVertex {
        private Integer dis = null;
        private Vertex prevV = null;
        public DistanceAndPrevVertex() {}

        public Integer getDis() {
            return dis;
        }

        public void setDis(Integer dis) {
            this.dis = dis;
        }

        public Vertex getPrevV() {
            return prevV;
        }

        public void setPrevV(Vertex prevV) {
            this.prevV = prevV;
        }
    }

//-------------------------------------------test code------------------------------------------------------//
    void printGraph(Graph g) {
        Vertex[] vertexes = g.getVertexes();
        if(null != vertexes) {
            for(Vertex v : vertexes) {
                printPath(v);
            }
        }
    }

    private void printPath(Vertex v) {
        if(v!= null) {
            List<Edge> edges = v.getToEdges();
            if(null != edges && edges.size() > 0) {
                for(Edge e : edges) {
                    if(!e.isVisited()) {
                        System.out.println("from vertex:"+e.getFromVertex().getVertexName()
                                           +"-to vertex:"+e.getToVertex().getVertexName()
                                           +"-weight:"+e.getWeight());
                        e.setVisited();
                        printPath(e.getToVertex());
                    }
                }
            }

        }
    }

}