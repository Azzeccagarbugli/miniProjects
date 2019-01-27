package it.unicam.cs.asdl1819.miniproject3;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AdjacentListDirectedGraphTest {

    @Test(timeout = 5000)
    public final void testNodeCount() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        assertEquals(0, g.nodeCount());
        g.addNode(new DefaultGraphNode<String>("s"));
        assertEquals(1, g.nodeCount());
        g.addNode(new DefaultGraphNode<String>("u"));
        assertEquals(2, g.nodeCount());
    }

    @Test(timeout = 5000)
    public final void testEdgeCount() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        assertEquals(0, g.edgeCount());
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        assertEquals(0, g.edgeCount());
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        assertEquals(2, g.edgeCount());
    }

    @Test(timeout = 5000)
    public final void testSize() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        assertEquals(0, g.size());
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        assertEquals(1, g.size());
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        assertEquals(3, g.size());
        g.addEdge(esu);
        assertEquals(3, g.size());
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        assertEquals(5, g.size());
    }

    @Test(timeout = 5000)
    public final void testIsEmpty() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        assertEquals(true, g.isEmpty());
        g.addNode(new DefaultGraphNode<String>("s"));
        assertEquals(false, g.isEmpty());
    }

    @Test(timeout = 5000)
    public final void testClear() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        g.addEdge(esu);
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        assertEquals(false, g.isEmpty());
        g.clear();
        assertEquals(true, g.isEmpty());
    }

    @Test(timeout = 5000)
    public final void testIsDirected() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        assertEquals(true, g.isDirected());
    }

    @Test(timeout = 5000)
    public final void testGetNodes() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        Set<GraphNode<String>> nodes = g.getNodes();
        assertEquals(true, nodes.isEmpty());
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        nodes = g.getNodes();
        Set<GraphNode<String>> testNodes = new HashSet<GraphNode<String>>();
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        GraphNode<String> nuTest = new DefaultGraphNode<String>("u");
        testNodes.add(nuTest);
        testNodes.add(nsTest);
        assertEquals(true, nodes.equals(testNodes));
        GraphNode<String> nuTestBis = new DefaultGraphNode<String>("u");
        g.addNode(nuTestBis);
        nodes = g.getNodes();
        assertEquals(true, nodes.equals(testNodes));
    }

    @Test(timeout = 5000)
    public final void testAddNode() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        assertEquals(false, g.containsNode(ns));
        g.addNode(ns);
        assertEquals(true, g.containsNode(nsTest));
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        GraphNode<String> nuTest = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        assertEquals(true, g.containsNode(nuTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testAddNodeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        g.addNode(null);
    }

    @Test(timeout = 5000, expected = UnsupportedOperationException.class)
    public final void testRemoveNode() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        g.removeNode(nsTest);
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testRemoveNodeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.removeNode(null);
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testContainsNodeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.containsNode(null);
    }

    @Test(timeout = 5000)
    public final void testContainsNode() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        assertEquals(false, g.containsNode(nsTest));
        g.addNode(ns);
        assertEquals(true, g.containsNode(nsTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetNodeIndexNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        g.getNodeIndex(null);
    }

    @Test(timeout = 5000, expected = UnsupportedOperationException.class)
    public final void testGetNodeIndex() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.getNodeIndex("s");
    }

    @Test(timeout = 5000, expected = UnsupportedOperationException.class)
    public final void testGetNodeAtIndex() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.getNodeAtIndex(0);
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetAdjacentNodeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.getAdjacentNodes(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetAdjacentNodesIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.getAdjacentNodes(nu);
    }

    @Test(timeout = 5000)
    public final void testGetAdjacentNodes() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        Set<GraphNode<String>> adjNodes = new HashSet<GraphNode<String>>();
        assertEquals(true, g.getAdjacentNodes(ns).equals(adjNodes));
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        GraphNode<String> nuTest = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        GraphNode<String> nxTest = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        adjNodes.add(nxTest);
        adjNodes.add(nuTest);
        assertEquals(true, g.getAdjacentNodes(nsTest).equals(adjNodes));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetPredecessorNodesNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.getPredecessorNodes(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetPredecessorNodesIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.getPredecessorNodes(nu);
    }

    @Test(timeout = 5000)
    public final void testGetPredecessorNodes() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        Set<GraphNode<String>> predNodes = new HashSet<GraphNode<String>>();
        assertEquals(true, g.getPredecessorNodes(ns).equals(predNodes));
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        GraphNode<String> nuTest = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        GraphNode<String> nxTest = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        GraphEdge<String, String> eux = new DefaultGraphEdge<String, String>(nu,
                nx, "from u to x", true, 2.05);
        g.addEdge(eux);
        GraphEdge<String, String> exu = new DefaultGraphEdge<String, String>(nx,
                nu, "from x to u", true, 3.04);
        g.addEdge(exu);
        assertEquals(true, g.getPredecessorNodes(ns).equals(predNodes));
        GraphNode<String> ny = new DefaultGraphNode<String>("y");
        GraphNode<String> nyTest = new DefaultGraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String, String> exy = new DefaultGraphEdge<String, String>(nx,
                ny, "from x to y", true, 2.0);
        g.addEdge(exy);
        GraphEdge<String, String> eys = new DefaultGraphEdge<String, String>(ny,
                ns, "from y to s", true, 7.03);
        g.addEdge(eys);
        predNodes.add(nyTest);
        assertEquals(true, g.getPredecessorNodes(nsTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nsTest);
        predNodes.add(nxTest);
        assertEquals(true, g.getPredecessorNodes(nuTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nsTest);
        predNodes.add(nuTest);
        assertEquals(true, g.getPredecessorNodes(nxTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nxTest);
        assertEquals(true, g.getPredecessorNodes(nyTest).equals(predNodes));
    }

    @Test(timeout = 5000)
    public final void testGetEdges() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String, String>> edgesTest = new HashSet<GraphEdge<String, String>>();
        assertEquals(true, g.getEdges().equals(edgesTest));
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        edgesTest.add(esu);
        assertEquals(true, g.getEdges().equals(edgesTest));
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        GraphEdge<String, String> eux = new DefaultGraphEdge<String, String>(nu,
                nx, "from u to x", true, 2.05);
        g.addEdge(eux);
        GraphEdge<String, String> exu = new DefaultGraphEdge<String, String>(nx,
                nu, "from x to u", true, 3.04);
        g.addEdge(exu);
        edgesTest.add(eux);
        edgesTest.add(esx);
        edgesTest.add(exu);
        assertEquals(true, g.getEdges().equals(edgesTest));
        GraphNode<String> ny = new DefaultGraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String, String> exy = new DefaultGraphEdge<String, String>(nx,
                ny, "from x to y", true, 2.0);
        g.addEdge(exy);
        GraphEdge<String, String> eys = new DefaultGraphEdge<String, String>(ny,
                ns, "from y to s", true, 7.03);
        g.addEdge(eys);
        edgesTest.add(eys);
        edgesTest.add(exy);
        assertEquals(true, g.getEdges().equals(edgesTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testAddEdgeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.addEdge(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testAddEdgeIllegal1() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        // g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testAddEdgeIllegal2() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", false, 10.1);
        g.addEdge(esu);
    }

    @Test(timeout = 5000)
    public final void testAddEdge() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        Set<GraphEdge<String, String>> edgesTest = new HashSet<GraphEdge<String, String>>();
        Set<GraphEdge<String, String>> edges = g.getEdges();
        assertEquals(true, edges.equals(edgesTest));
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        GraphEdge<String, String> esuTest = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to u", true, 10.1);
        assertEquals(true, g.containsEdge(esuTest));
        edgesTest.add(esuTest);
        edges = g.getEdges();
        assertEquals(true, edges.equals(edgesTest));
    }

    @Test(timeout = 5000, expected = UnsupportedOperationException.class)
    public final void testRemoveEdge() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        g.removeEdge(esu);
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testContainsEdgeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        GraphEdge<String, String> esuTest = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to u", true, 10.1);
        assertEquals(false, g.containsEdge(null));
        g.addEdge(esu);
        assertEquals(true, g.containsEdge(esuTest));
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testContainsEdgeIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        // g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        assertEquals(true, g.containsEdge(esu));
    }

    @Test(timeout = 5000)
    public final void testContainsEdge() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        GraphEdge<String, String> esuTest = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to u", true, 10.1);
        assertEquals(false, g.containsEdge(esuTest));
        g.addEdge(esu);
        assertEquals(true, g.containsEdge(esuTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetEdgesGraphNodeOfVNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        g.getEdges(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetEdgesGraphNodeOfVIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        // g.addNode(nu);
        // GraphEdge<String, String> esu = new DefaultGraphEdge<String,
        // String>(ns,
        // nu, "from s to u", true, 10.1);
        // g.addEdge(esu);
        g.getEdges(nu);
    }

    @Test(timeout = 5000)
    public final void testGetEdgesGraphNodeOfV() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        Set<GraphEdge<String, String>> edgesTest = new HashSet<GraphEdge<String, String>>();
        Set<GraphEdge<String, String>> edges = g.getEdges(ns);
        assertEquals(true, edges.equals(edgesTest));
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        GraphEdge<String, String> esuTest = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to u", true, 10.1);
        edgesTest.add(esuTest);
        edges = g.getEdges(ns);
        assertEquals(true, edges.equals(edgesTest));
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        GraphEdge<String, String> esxTest = new DefaultGraphEdge<String, String>(
                ns, nx, "from s to x", true, 5.12);
        edgesTest.add(esxTest);
        edges = g.getEdges(ns);
        assertEquals(true, edges.equals(edgesTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetIngoingEdgesNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        g.getIngoingEdges(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetIngoingEdgesIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        // g.addNode(nu);
        g.getIngoingEdges(nu);
    }

    @Test(timeout = 5000)
    public final void testGetIngoingEdges() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String, String>> ingoingEdgesTest = new HashSet<GraphEdge<String, String>>();
        assertEquals(true, g.getIngoingEdges(ns).equals(ingoingEdgesTest));
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        GraphEdge<String, String> esuTest = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        GraphEdge<String, String> esxTest = new DefaultGraphEdge<String, String>(
                ns, nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        GraphEdge<String, String> eux = new DefaultGraphEdge<String, String>(nu,
                nx, "from u to x", true, 2.05);
        GraphEdge<String, String> euxTest = new DefaultGraphEdge<String, String>(
                nu, nx, "from u to x", true, 2.05);
        g.addEdge(eux);
        GraphEdge<String, String> exu = new DefaultGraphEdge<String, String>(nx,
                nu, "from x to u", true, 3.04);
        GraphEdge<String, String> exuTest = new DefaultGraphEdge<String, String>(
                nx, nu, "from x to u", true, 3.04);
        g.addEdge(exu);
        GraphNode<String> ny = new DefaultGraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String, String> exy = new DefaultGraphEdge<String, String>(nx,
                ny, "from x to y", true, 2.0);
        GraphEdge<String, String> exyTest = new DefaultGraphEdge<String, String>(
                nx, ny, "from x to y", true, 2.0);
        g.addEdge(exy);
        GraphEdge<String, String> eys = new DefaultGraphEdge<String, String>(ny,
                ns, "from y to s", true, 7.03);
        GraphEdge<String, String> eysTest = new DefaultGraphEdge<String, String>(
                ny, ns, "from y to s", true, 7.03);
        g.addEdge(eys);
        ingoingEdgesTest.add(eysTest);
        assertEquals(true, g.getIngoingEdges(ns).equals(ingoingEdgesTest));
        ingoingEdgesTest.clear();
        ingoingEdgesTest.add(exyTest);
        assertEquals(true, g.getIngoingEdges(ny).equals(ingoingEdgesTest));
        ingoingEdgesTest.clear();
        ingoingEdgesTest.add(esxTest);
        ingoingEdgesTest.add(euxTest);
        assertEquals(true, g.getIngoingEdges(nx).equals(ingoingEdgesTest));
        ingoingEdgesTest.clear();
        ingoingEdgesTest.add(esuTest);
        ingoingEdgesTest.add(exuTest);
        assertEquals(true, g.getIngoingEdges(nu).equals(ingoingEdgesTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetDegreeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        g.getDegree(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetDegreeIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        // g.addNode(nu);
        g.getDegree(nu);
    }

    @Test(timeout = 5000)
    public final void testGetDegree() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        assertEquals(0, g.getDegree(ns));
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new DefaultGraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String, String> esx = new DefaultGraphEdge<String, String>(ns,
                nx, "from s to x", true, 5.12);
        g.addEdge(esx);
        GraphEdge<String, String> eux = new DefaultGraphEdge<String, String>(nu,
                nx, "from u to x", true, 2.05);
        g.addEdge(eux);
        GraphEdge<String, String> exu = new DefaultGraphEdge<String, String>(nx,
                nu, "from x to u", true, 3.04);
        g.addEdge(exu);
        GraphNode<String> ny = new DefaultGraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String, String> exy = new DefaultGraphEdge<String, String>(nx,
                ny, "from x to y", true, 2.0);
        g.addEdge(exy);
        GraphEdge<String, String> eys = new DefaultGraphEdge<String, String>(ny,
                ns, "from y to s", true, 7.03);

        g.addEdge(eys);
        GraphNode<String> nv = new DefaultGraphNode<String>("v");
        g.addNode(nv);
        GraphEdge<String, String> euv = new DefaultGraphEdge<String, String>(nu,
                nv, "from u to v", true, 1.0);
        g.addEdge(euv);
        GraphEdge<String, String> exv = new DefaultGraphEdge<String, String>(nx,
                nv, "from u to v", true, 9.05);
        g.addEdge(exv);
        GraphEdge<String, String> eyv = new DefaultGraphEdge<String, String>(ny,
                nv, "from y to v", true, 6.0);
        g.addEdge(eyv);
        GraphEdge<String, String> evy = new DefaultGraphEdge<String, String>(nv,
                ny, "from v to y", true, 4.07);
        g.addEdge(evy);
        assertEquals(3, g.getDegree(ns));
        assertEquals(5, g.getDegree(nx));
        assertEquals(4, g.getDegree(nu));
        assertEquals(4, g.getDegree(nv));
        assertEquals(4, g.getDegree(ny));
    }

    @Test(timeout = 5000, expected = UnsupportedOperationException.class)
    public final void testGetEdgesBetweenIntInt() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        g.getEdgesBetween(0, 1);
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetEdgesBetweenGraphNodeOfVGraphNodeOfVNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        g.getEdgesBetween(ns, null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetEdgesBetweenGraphNodeOfVGraphNodeOfVIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        // g.addNode(nu);
        g.getEdgesBetween(ns, nu);
    }

    @Test(timeout = 5000)
    public final void testGetEdgesBetweenGraphNodeOfVGraphNodeOfV() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        Set<GraphEdge<String, String>> edgesTest = new HashSet<GraphEdge<String, String>>();
        assertEquals(true, edgesTest.equals(g.getEdgesBetween(ns, nu)));
        GraphEdge<String, String> esu = new DefaultGraphEdge<String, String>(ns,
                nu, "from s to u", true, 10.1);
        g.addEdge(esu);
        GraphEdge<String, String> esuTest = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to u", true, 10.1);
        edgesTest.add(esuTest);
        assertEquals(true, g.getEdgesBetween(ns, nu).equals(edgesTest));
        GraphEdge<String, String> esuBis = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to u", true, 10.1);
        g.addEdge(esuBis);
        assertEquals(true, g.getEdgesBetween(ns, nu).equals(edgesTest));
        GraphEdge<String, String> esuDiversoLabel = new DefaultGraphEdge<String, String>(
                ns, nu, "pippo", true, 10.1);
        g.addEdge(esuDiversoLabel);
        GraphEdge<String, String> esuDiversoLabelTest = new DefaultGraphEdge<String, String>(
                ns, nu, "pippo", true, 10.1);
        edgesTest.add(esuDiversoLabelTest);
        assertEquals(true, g.getEdgesBetween(ns, nu).equals(edgesTest));
        GraphEdge<String, String> esuDiversoLabelNull = new DefaultGraphEdge<String, String>(
                ns, nu, null, true, 10.1);
        g.addEdge(esuDiversoLabelNull);
        GraphEdge<String, String> esuDiversoLabelNullTest = new DefaultGraphEdge<String, String>(
                ns, nu, null, true, 10.1);
        edgesTest.add(esuDiversoLabelNullTest);
        assertEquals(true, g.getEdgesBetween(ns, nu).equals(edgesTest));
        GraphEdge<String, String> esuDiversoPeso = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to v", true, 1.1);
        g.addEdge(esuDiversoPeso);
        GraphEdge<String, String> esuDiversoPesoTest = new DefaultGraphEdge<String, String>(
                ns, nu, "from s to v", true, 1.1);
        edgesTest.add(esuDiversoPesoTest);
        assertEquals(true, g.getEdgesBetween(ns, nu).equals(edgesTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetNodeNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        g.getNode(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetNodeIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
        // GraphNode<String> nu = new DefaultGraphNode<String>("u");
        // g.addNode(nu);
        g.getNode("u");
    }

    @Test(timeout = 5000)
    public final void testGetNode() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        ns.setColor(1);
        g.addNode(ns);
        GraphNode<String> nu = new DefaultGraphNode<String>("u");
        g.addNode(nu);
        GraphNode<String> node = g.getNode("s");
        assertEquals("s", node.getLabel());
        assertEquals(1, node.getColor());
        node = g.getNode("u");
        assertEquals("u", node.getLabel());
        assertEquals(0, node.getColor());

    }
}
