include recipes-core/images/core-image-base.bb

LICENSE = "MIT"
DESCRIPTION = "A Core image based on core-image-base for rpi"

IMAGE_FEATURES:append = " ssh-server-dropbear package-management"

IMAGE_INSTALL:append = " tpm2-tools libtss2 libtss2-tcti-device libtss2-tcti-mssim tpm2-abrmd tpm2-pkcs11 slb9670"

KERNEL_DEVICETREE:append = " overlays/letstrust-tpm.dtbo"
