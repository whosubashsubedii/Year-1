public class StandardVisitor extends ArtGalleryVisitor 
{
    private boolean isEligibleForDiscountUpgrade;
    private final int visitLimit;
    private float discountPercent;
    private boolean isActive;

    public StandardVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate, double ticketCost, String ticketType) 
    {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
        this.visitLimit = 5;
        this.discountPercent = 0.10f;
        this.isEligibleForDiscountUpgrade = false;
        this.isActive = false;
    }

    // Accessors
    public boolean getIsEligibleForDiscountUpgrade()
    {
        return isEligibleForDiscountUpgrade;
    }

    public int getVisitLimit() 
    {
        return visitLimit;
    }

    public float getDiscountPercent() 
    {
        return discountPercent;
    }

    // Check for discount eligibility
    public boolean checkDiscountUpgrade()
    {
        if (visitCount >= visitLimit) {
            isEligibleForDiscountUpgrade = true;
            discountPercent = 0.15f;
        }
        return isEligibleForDiscountUpgrade;
    }

    // Buy product
    @Override
    public String buyProduct(String artworkName, double artworkPrice)
    {
        if (!isActive) 
        {
            return "Please log in before making a purchase.";
        }

        if (!isBought || (this.artworkName == null) || !this.artworkName.equals(artworkName)) {
            this.artworkName = artworkName;
            this.artworkPrice = artworkPrice;
            this.isBought = true;
            this.buyCount++;
            this.finalPrice = calculateDiscount();
            this.rewardPoints += finalPrice * 5;
            return "Purchase successful: " + artworkName + " for $" + artworkPrice;
        } else {
            return "You have already purchased this artwork.";
        }
    }

    // Generate bill
    @Override
    public void generateBill()
    {
        if (isBought) {
            System.out.println("Visitor ID      : " + getVisitorId());
            System.out.println("Visitor Name    : " + getFullName());
            System.out.println("Artwork Name    : " + artworkName);
            System.out.println("Artwork Price   : " + artworkPrice);
            System.out.println("Discount Percent: " + (discountPercent * 100) + "%");
            System.out.println("Final Price     : " + finalPrice);
        } else {
            System.out.println("There is no purchase to generate bill.");
        }
    }

    // Cancel product
    @Override
    public String cancelProduct(String artworkName, String cancellationReason)
    {
        if (cancelCount >= 3) {
            terminateVisitor();
            return "The visitor has reached the cancel limit. Visitor record terminated.";
        } else if (buyCount > 0) {
            if (artworkName.equals(getArtworkName())) {
                this.artworkName = null;
                this.isBought = false;
                this.refundableAmount = artworkPrice * 0.9;
                this.cancelCount++;
                this.buyCount--;
                this.rewardPoints -= finalPrice * 5;
                this.cancellationReason = cancellationReason;
                return "The purchase was cancelled successfully. Refundable amount: " + refundableAmount;
            } else {
                return "The artwork name is incorrect.";
            }
        } else {
            return "There is no product to cancel.";
        }
    }

    // Calculate reward points
    @Override
    public double calculateRewardPoints()
    {
        if (isBought) 
        {
            double finalPrice = calculateDiscount();
            rewardPoints += finalPrice * 5;
        }
        return rewardPoints;
    }

    // Calculate discount
    @Override
    public double calculateDiscount()
    {
        if (isBought) {
            checkDiscountUpgrade();
            return artworkPrice - (artworkPrice * discountPercent);
        } else {
            return 0.0;
        }
    }

    // Terminate visitor
    private void terminateVisitor()
    {
        isActive = false;
        isEligibleForDiscountUpgrade = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }

    // Activate visitor
    public void setIsActive() 
    {
        this.isActive = true;
    }

    // Display visitor details
    @Override
    public void display() {
        super.display();
        System.out.println("Eligible for Discount Upgrade: " + isEligibleForDiscountUpgrade);
        System.out.println("Visit Limit                 : " + visitLimit);
        System.out.println("Discount Percent            : " + (discountPercent * 100) + "%");
    }

    // Sample test
    public static void main(String[] args) 
    {
        StandardVisitor visitor = new StandardVisitor(1, "ABC DEF", "Male", "028415895", "2000-10-01", 1000.0, "Standard");

        System.out.println("Visitor ID: " + visitor.getVisitorId());
        System.out.println("Full Name: " + visitor.getFullName());

        visitor.setIsActive();
        visitor.incrementVisitCount();
        visitor.incrementVisitCount();

        String bought = visitor.buyProduct("XAY", 11000.0);
        System.out.println(bought);
        visitor.generateBill();
    }
}
