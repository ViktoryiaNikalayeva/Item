package utils;

   public enum HighDomain {
    ORG(".org"),
    UK(".co.uk"),
    NET(".net"),
    GOV(".gov"),
    DE(".de"),
    FR(".fr"),
    NL(".nl"),
    COM(".com"),
    BE(".be"),
    JPG(".jpg");

    private final String hd;

    HighDomain(String hd) {
        this.hd = hd;
    }

    public String getHd() {
        return hd;
    }
}
