/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package cableway.station;

import cableway.CablewayException;
import cableway.cabin.Cabin;
import cableway.cable.Cable;
import cableway.people.PeopleSet;

/**
 * Cableway station class.
 *
 * @author giuliobosco
 * @version 1.0.2
 */
public class Station extends Thread {
    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * People ready to step up on the cabin.
     */
    private PeopleSet readyPeople;

    /**
     * Is the in people area active, if is active will be used 2 people sets, else will be used only
     * one (readyPeople).
     */
    private boolean inPeopleActive;

    /**
     * People ready to go in the ready people space.
     */
    private PeopleSet inPeople;

    /**
     * Cableway cabin 0.
     */
    private Cabin cabin0;

    /**
     * Cableway cabin 1.
     */
    private Cabin cabin1;

    /**
     * Cableway cable.
     */
    private Cable cable;

    /**
     * Platform for cabin 0.
     */
    private Platoform platoform0;

    /**
     * Platform for cabin 1.
     */
    private Platoform platoform1;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the people ready to step up on the cabin.
     *
     * @param readyPeople People ready to step up on the cabin.
     */
    public void setReadyPeople(PeopleSet readyPeople) {
        this.readyPeople = readyPeople;
    }

    /**
     * Get the people ready to step up on the cabin.
     *
     * @return People ready to step up on the cabin.
     */
    public PeopleSet getReadyPeople() {
        return this.readyPeople;
    }

    /**
     * Set the is the in people area active.
     *
     * @param inPeopleActive Is the in people area active.
     */
    public void setInPeopleActive(boolean inPeopleActive) {
        this.inPeopleActive = inPeopleActive;
    }

    /**
     * Get the is the in people area active.
     *
     * @return Is the in people area active.
     */
    public boolean isInPeopleActive() {
        return this.inPeopleActive;
    }

    /**
     * Set the people ready to go in the ready people space.
     *
     * @param inPeople People ready to go in the ready people space.
     */
    public void setInPeople(PeopleSet inPeople) {
        this.inPeople = inPeople;
    }

    /**
     * Get the people ready to go in the ready people space.
     *
     * @return People ready to go in the ready people space.
     */
    public PeopleSet getInPeople() {
        return this.inPeople;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the station with the cable and the two cabins.
     *
     * @param cable Cableway cable.
     * @param cabin0 Cableway cabin 0.
     * @param cabin1 Cableway cabin 1.
     * @throws CablewayException Cableway exception, error with the cabin or the cable.
     */
    public Station(Cable cable, Cabin cabin0, Cabin cabin1, Platoform platoform0, Platoform platoform1) throws CablewayException {
        if (cabin0 != cabin1) {
            if (cabin0.getCable() == cable && cabin1.getCable() == cable) {
                this.cable = cable;
                this.cabin0 = cabin0;
                this.cabin1 = cabin1;

                if (platoform0 != platoform1) {
                    this.platoform0 = platoform0;
                    this.platoform1 = platoform1;
                } else {
                    throw new CablewayException("Platforms can't be the same", CablewayException.FATAL);
                }
            } else {
                String message = CablewayException.FATAL_TEXT + "\nWrong cable connected to the cabins.";
                throw new CablewayException(message, CablewayException.FATAL);
            }
        } else {
            String message = CablewayException.FATAL_TEXT + "\nCabins cant't be the same.";
            throw new CablewayException(message, CablewayException.FATAL);
        }
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods
    // --------------------------------------------------------------------------- Static Components

}
