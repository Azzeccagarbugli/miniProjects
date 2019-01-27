package it.unicam.cs.asdl1819.miniproject3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DijkstraShortestPathComputerTest {

    @SuppressWarnings("unused")
    @Test(timeout = 5000)
    public final void testDijkstraShortestPathComputerOk() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
    }

    @SuppressWarnings("unused")
    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testDijkstraShortestPathComputerNull() {
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                null);
    }

    @SuppressWarnings("unused")
    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testDijkstraShortestPathComputerIllegal1() {
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                new AdjacentListDirectedGraph<String, String>());
    }

    @SuppressWarnings("unused")
    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testDijkstraShortestPathComputerIllegal2() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
                nx, "from u to x", true);
        g.addEdge(eux);
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);

    }

    @SuppressWarnings("unused")
    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testDijkstraShortestPathComputerIllegal3() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
                nx, "from u to x", true, -4.0);
        g.addEdge(eux);
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testComputeShortestPathsFromNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        c.computeShortestPathsFrom(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testComputeShortestPathsFromIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        GraphNode<String> nsTestError = new DefaultGraphNode<String>("p");
        c.computeShortestPathsFrom(nsTestError);
    }

    @Test(timeout = 5000)
    public final void testIsComputed() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        assertEquals(false, c.isComputed());
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        c.computeShortestPathsFrom(nsTest);
        assertEquals(true, c.isComputed());
    }

    @Test(timeout = 5000, expected = IllegalStateException.class)
    public final void testGetLastSourceIllegal() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        c.getLastSource();
    }

    @Test(timeout = 5000)
    public final void testGetLastSource() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        c.computeShortestPathsFrom(nsTest);
        assertEquals(true, c.getLastSource().equals(nsTest));
    }

    @Test(timeout = 5000, expected = NullPointerException.class)
    public final void testGetShortestPathToNull() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        c.computeShortestPathsFrom(ns);
        c.getShortestPathTo(null);
    }

    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public final void testGetShortestPathToIllegalArgument1() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        c.computeShortestPathsFrom(ns);
        GraphNode<String> nsTestWrong = new DefaultGraphNode<String>("g");
        c.computeShortestPathsFrom(nsTestWrong);
    }

    @Test(timeout = 5000, expected = IllegalStateException.class)
    public final void testGetShortestPathToIllegalState() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        c.getShortestPathTo(nsTest);
    }

    @Test(timeout = 5000)
    public final void testGetShortestPathTo() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        c.computeShortestPathsFrom(nsTest);
        List<GraphEdge<String, String>> pathTest = new ArrayList<GraphEdge<String, String>>();
        assertEquals(true, c.getShortestPathTo(nsTest).equals(pathTest));
        GraphNode<String> nuTest = new DefaultGraphNode<String>("u");
        GraphNode<String> nxTest = new DefaultGraphNode<String>("x");
        GraphEdge<String, String> esxTest = new DefaultGraphEdge<String, String>(
                nsTest, nxTest, "from s to x", true, 5.12);
        pathTest.add(esxTest);
        assertEquals(true, c.getShortestPathTo(nxTest).equals(pathTest));
        GraphEdge<String, String> exuTest = new DefaultGraphEdge<String, String>(
                nxTest, nuTest, "from x to u", true, 3.04);
        pathTest.add(exuTest);
        assertEquals(true, c.getShortestPathTo(nuTest).equals(pathTest));
        GraphNode<String> nvTest = new DefaultGraphNode<String>("v");
        GraphEdge<String, String> euvTest = new DefaultGraphEdge<String, String>(
                nuTest, nvTest, "from u to v", true, 1.0);
        pathTest.add(euvTest);
        assertEquals(true, c.getShortestPathTo(nvTest).equals(pathTest));
        pathTest.clear();
        pathTest.add(esxTest);
        GraphNode<String> nyTest = new DefaultGraphNode<String>("y");
        GraphEdge<String, String> exyTest = new DefaultGraphEdge<String, String>(
                nxTest, nyTest, "from x to y", true, 2.0);
        pathTest.add(exyTest);
        assertEquals(true, c.getShortestPathTo(nyTest).equals(pathTest));
    }

    @Test(timeout = 5000)
    public final void testGetShortestPathUnreachable() {
        Graph<String, String> g = new AdjacentListDirectedGraph<String, String>();
        GraphNode<String> ns = new DefaultGraphNode<String>("s");
        g.addNode(ns);
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
        GraphNode<String> np = new DefaultGraphNode<String>("p");
        g.addNode(np);
        GraphEdge<String, String> epv = new DefaultGraphEdge<String, String>(np,
                nv, "from p to v", true, 1.0);
        g.addEdge(epv);
        // p è collegato a v, ma non è raggiungibile da s
        DijkstraShortestPathComputer<String, String> c = new DijkstraShortestPathComputer<String, String>(
                g);
        GraphNode<String> nsTest = new DefaultGraphNode<String>("s");
        c.computeShortestPathsFrom(nsTest);
        GraphNode<String> npTest = new DefaultGraphNode<String>("p");
        assertEquals(null, c.getShortestPathTo(npTest));
    }
}
