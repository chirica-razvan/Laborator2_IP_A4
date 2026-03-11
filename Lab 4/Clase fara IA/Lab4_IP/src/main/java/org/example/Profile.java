package org.example;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    // --- Attributes ---
    private String profileId;
    private String username;
    private List<Setup> setups;

    // Constructor for the Profile
    public Profile(String profileId, String username) {
        this.profileId = profileId;
        this.username = username;
        this.setups = new ArrayList<>();
    }

    // --- Inner Class representing a Setup ---
    public class Setup {
        private String profileId;
        private int setupId; // This will depend on the profile's number of setups
        private String description;
        private List<Double> ratings;

        public Setup(String profileId, int setupId, String description) {
            this.profileId = profileId;
            this.setupId = setupId;
            this.description = description;
            this.ratings = new ArrayList<>();
        }

        // Method to add a rating
        public void addRating(double rating) {
            if (rating >= 1.0 && rating <= 5.0) {
                ratings.add(rating);
            } else {
                System.out.println("Rating must be between 1.0 and 5.0");
            }
        }

        // Calculate average rating
        public double getAverageRating() {
            if (ratings.isEmpty()) return 0.0;
            double sum = 0;
            for (double r : ratings) {
                sum += r;
            }
            return sum / ratings.size();
        }

        @Override
        public String toString() {
            return "Setup ID: " + profileId + "-" + setupId +
                    " | Desc: '" + description + "'" +
                    " | Avg Rating: " + String.format("%.2f", getAverageRating()) +
                    " (" + ratings.size() + " ratings)";
        }
    }

    // --- The Important Methods ---

    /**
     * Creates a new setup for this profile. 
     * The setupId is automatically generated based on the current number of setups.
     */
    public void createNewSetup(String description) {
        // The setup ID depends on the profile's number of setups (1-based index)
        int newSetupId = setups.size() + 1;
        Setup newSetup = new Setup(this.profileId, newSetupId, description);
        setups.add(newSetup);
    }

    /**
     * Adds a rating to a specific setup.
     */
    public void rateSetup(int setupId, double rating) {
        // setupId maps directly to the list index (setupId 1 is index 0)
        if (setupId > 0 && setupId <= setups.size()) {
            setups.get(setupId - 1).addRating(rating);
        } else {
            System.out.println("Error: Setup ID " + setupId + " not found!");
        }
    }

    /**
     * Displays the full profile and its setups.
     */
    public void displayProfileSummary() {
        System.out.println("\n=== Profile Summary ===");
        System.out.println("User: " + username + " (Profile ID: " + profileId + ")");
        System.out.println("Total Setups Shared: " + setups.size());
        for (Setup setup : setups) {
            System.out.println("  -> " + setup.toString());
        }
        System.out.println("=======================\n");
    }

}