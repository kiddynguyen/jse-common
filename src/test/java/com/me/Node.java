/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me;

class Node {
    
    // keep these fields
    Node left, right;
	int value;

    Node find(int v) {
        if (v == value) {
            return this;
        } if (v < value) {
            if (left != null) {
                return left.find(v);
            } else {
                return null;
            }
        } else {
            if (right != null) {
                return right.find(v);
            } else {
                return null;
            }
        }
    }
    
    Node find3(int v) {
        return find2(v, this);
    }
    
    Node find2(int v, Node node) {
        while (node != null) {
            if (v == node.value) {
                return node;
            } else if (v < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}
