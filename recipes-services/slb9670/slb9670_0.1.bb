SUMMARY = "Install a service that instantiate the communication between the raspberry and the TPM SLB9670"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://slb9670-rpi.service"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
    install -m 0644 ${WORKDIR}/slb9670-rpi.service ${D}${systemd_system_unitdir}
    ln -s ${D}${systemd_system_unitdir}/slb9670-rpi.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants
}

FILES:${PN} += "${systemd_system_unitdir}/slb9670-rpi.service"

REQUIRED_DISTRO_FEATURES = "systemd"
