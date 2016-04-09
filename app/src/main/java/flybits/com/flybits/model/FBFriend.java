package flybits.com.flybits.model;

/**
 * Created by larrychong on 16-04-09.
 */
public class FBFriend {
    private String profileUrl;
    private String profileName;
    private int amountTimeSpent;

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getAmountTimeSpent() {
        return amountTimeSpent;
    }

    public void setAmountTimeSpent(int amountTimeSpent) {
        this.amountTimeSpent = amountTimeSpent;
    }
}
