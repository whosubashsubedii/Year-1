public class EliteVisitor extends ArtGalleryVisitor
{
    private boolean assignedPersonalArtAdvisor;
    private boolean exclusiveEventAccess;

    // Constructor
    public EliteVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate, double ticketCost, String ticketType)

    {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
        this.assignedPersonalArtAdvisor = false;
        this.exclusiveEventAccess = false;
    }

    // Accessor methods
    public boolean isAssignedPersonalArtAdvisor() 
    {
        return assignedPersonalArtAdvisor;
    }

    public boolean getExclusiveEventAccess() 
    {
        return exclusiveEventAccess;
    }

    //reward points
    public boolean assignedPersonalArtAdvisor()
    {
        if (getRewardPoints() > 5000)
        {
            assignedPersonalArtAdvisor = true;
        }
        return assignedPersonalArtAdvisor;
    }

    public boolean exclusiveEventAccess()
    {
        if (assignedPersonalArtAdvisor)
        {
            exclusiveEventAccess = true;
        }
        return exclusiveEventAccess;
    }

    @Override
    public String buyProduct(String artworkName, double artworkPrice)
    {
        if (!isActive)
        {
            return "You need to be logged in first.";
        }

        if (this.artworkName == null || !artworkName.equals(this.artworkName))
        {
            this.artworkName = artworkName;
            this.artworkPrice = artworkPrice;
            this.isBought = true;
            this.buyCount++;
            calculateRewardPoints();
            return "Successfully purchased artwork: " + artworkName;
        } 
        else
        {
            return "This artwork has already been purchased.";
        }
    }

    // 40% discount for elite visitors
    @Override
    public double calculateDiscount()
    {
        discountAmount = artworkPrice * 0.40;
        finalPrice = artworkPrice - discountAmount;
        return finalPrice;
    }

    // 10 points per rupee spent after discount
    @Override
    public double calculateRewardPoints()
    {
        double discount = calculateDiscount();
        double finalPrice = artworkPrice - discount;
        rewardPoints += finalPrice * 10;
        return rewardPoints;
    }

    // Cancel product with refund and points deduction
    @Override
    public String cancelProduct(String artworkName, String cancellationReason)
    {
        if (cancelCount >= 3)
        {
            terminateVisitor();
            return "Account terminated due to excessive cancellations. Cancellation not processed.";
        }
        if (buyCount == 0)
        {
            return "No purchases made yet. Cannot cancel.";
        }

        if (!artworkName.equals(this.artworkName))
        {
            isBought = false;
            this.artworkName = null;
            double refundableAmount = artworkPrice - (artworkPrice * 0.05);
            this.rewardPoints -= finalPrice * 10;
            buyCount--;
            cancelCount++;
            this.cancellationReason = cancellationReason;
            return "Cancellation successful. Refundable amount: " + refundableAmount + " rupees.";
        }
        
        return "Artwork name does not match. Cancellation failed.";
    }

    // generate bill
    @Override
    public void generateBill()
    {
        if (!isBought)
        {
            double discount = calculateDiscount();
            double finalPrice = getArtworkPrice() - discount;


            System.out.println("= Art Purchase Bill =");
            System.out.println("Visitor ID      : " + getVisitorId());
            System.out.println("Full Name       : " + getFullName());
            System.out.println("Artwork Name    : " + getArtworkName());
            System.out.println("Artwork Price   : " + getArtworkPrice());
            System.out.println("Discount Amount : " + discountAmount);
            System.out.println("Final Price     : " + finalPrice);

        }
    else
        {
            System.out.println("No purchases made yet.");
        }
    }

     // Private termination method
    private void terminateVisitor() 
    {
        isActive = false;
        assignedPersonalArtAdvisor = false;
        exclusiveEventAccess = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }


    // Override display method
    @Override
    public void display() 
    {
        super.display();
        System.out.println("Assigned Personal Art Advisor : " + assignedPersonalArtAdvisor);
        System.out.println("Exclusive Event Access        : " + exclusiveEventAccess);
    }
}