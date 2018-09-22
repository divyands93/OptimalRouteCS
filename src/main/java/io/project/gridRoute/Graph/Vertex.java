package io.project.gridRoute.Graph;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Vertex {
	@JsonIgnore
    private boolean isVisited = false;

    private String vertexName = null;
    @JsonIgnore
    private List<Edge> toEdges = new ArrayList();

    public Vertex() {
       
    }
    public Vertex(String vertexName) {
   	 this.vertexName = vertexName;
    }
    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }
    public void addEdge(Edge toEdge) {
        this.toEdges.add(toEdge);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited() {
        this.isVisited = true;
    }

    public List<Edge> getToEdges() {
        return this.toEdges;
    }

    public String getVertexName() {
        return this.vertexName;
    }
}
