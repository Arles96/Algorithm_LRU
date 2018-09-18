/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lru;

/**
 *
 * @author arles
 */
public class Lru {
    
    private int [] array; 
    private int indexDead = 0;
    private int size;
    private int counter = 0;
    private int miss;
    private int hits;

    public Lru(int size) {
        this.size = size;
        this.array = new int [size];
    }

    public int[] getArray() {
        return array;
    }

    public int getIndexDead() {
        return indexDead;
    }

    public int getSize() {
        return size;
    }

    public int getMiss() {
        return miss;
    }

    public int getHits() {
        return hits;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setIndexDead(int indexDead) {
        this.indexDead = indexDead;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    // Metodos de administracion
    
    public void check (int x) {
        if (this.counter == 0 ) {
            this.array[counter] = x;
            this.counter++;
            this.miss++;
        } else {
            boolean exists = false;
            for (int i = 0; i < this.array.length; i++) {
                if (this.array[i] == x) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                if (this.counter < size) {
                    this.array[this.counter] = x;
                    this.counter++;
                    this.miss++;
                } else {
                    this.array[this.indexDead] = x;
                    this.indexDead = (this.indexDead + 1) % size;
                    this.miss++;
                }
            } else {
                this.indexDead = (this.indexDead + 1) % size;
                this.hits++;
            }
        }        
    }
       
    public String printArray () {
        String string = "[";
        for (int i = 0; i < this.size; i++) {
            if ( i == this.size - 1) {
                string += this.array[i] + "]\n";
            } else {
                string += this.array[i] + ",";
            }
        }
        return string;
    }
    
}
