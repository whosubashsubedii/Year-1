import java.io.Serializable;

public abstract class ArtGalleryVisitor implements Serializable 
{
    // Protected variables to subclasses
    protected int visitorId;
    protected String fullName;
    protected String gender;
    protected String contactNumber;
    protected String registrationDate;
    protected double ticketCost;
    protected String ticketType;
    protected int visitCount;
    protected double rewardPoints;
    protected final int cancelLimit;
    protected int cancelCount;
    protected String cancellationReason;
    protected double refundableAmount;
    protected boolean isActive;
    protected boolean isBought;
    protected int buyCount;
    protected double finalPrice;
    protected double discountAmount;
    protected String artworkName;
    protected double artworkPrice;

    // Constructor
    public ArtGalleryVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate,double ticketCost, String ticketType) 
    {
        this.visitorId = visitorId;
        this.fullName = fullName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.registrationDate = registrationDate;
        this.ticketCost = ticketCost;
        this.ticketType = ticketType;

        this.visitCount = 0;
        this.rewardPoints = 0.0;
        this.cancelLimit = 3;
        this.cancelCount = 0;
        this.cancellationReason = "None";
        this.refundableAmount = 0.0;
        this.isActive = false;
        this.isBought = false;
        this.buyCount = 0;
        this.finalPrice = 0.0;
        this.discountAmount = 0.0;
        this.artworkName = null;
        this.artworkPrice = 0.0;
    }

    // Getters
    public int getVisitorId()
    {
        return visitorId;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getGender()
    {
        return gender;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public double getTicketCost()
    {
        return ticketCost;
    }

    public String getTicketType()
    {
        return ticketType;
    }

    public int getVisitCount()
    {
        return visitCount;
    }

    public double getRewardPoints()
    {
        return rewardPoints;
    }

    public String getArtworkName()
    {
        return artworkName;
    }

    public double getArtworkPrice()
    {
        return artworkPrice;
    }

    // Setters
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public void setRewardPoints(double rewardPoints)
    {
        this.rewardPoints = rewardPoints;
    }

    public void incrementVisitCount()
    {
        visitCount++;
    }

    // Abstract methods to be implemented in subclass
    public abstract String buyProduct(String artworkName, double artworkPrice);

    public abstract double calculateDiscount();

    public abstract double calculateRewardPoints();

    public abstract String cancelProduct(String artworkName, String cancellationReason);

    public abstract void generateBill();

    // Display method
    public void display() {
        System.out.println("Visitor ID          : " + visitorId);
        System.out.println("Full Name           : " + fullName);
        System.out.println("Gender              : " + gender);
        System.out.println("Contact Number      : " + contactNumber);
        System.out.println("Registration Date   : " + registrationDate);
        System.out.println("Ticket Type         : " + ticketType);
        System.out.println("Ticket Cost         : " + ticketCost);
        System.out.println("Visit Count         : " + visitCount);
        System.out.println("Reward Points       : " + rewardPoints);
        System.out.println("Cancel Count        : " + cancelCount);
        System.out.println("Cancellation Reason : " + cancellationReason);
        System.out.println("Refundable Amount   : " + refundableAmount);
        System.out.println("Is Active           : " + isActive);
        System.out.println("Is Bought           : " + isBought);
        System.out.println("Buy Count           : " + buyCount);
        System.out.println("Final Price         : " + finalPrice);
        System.out.println("Discount Amount     : " + discountAmount);
        System.out.println("Artwork Name        : " + artworkName);
        System.out.println("Artwork Price       : " + artworkPrice);
    }
}
