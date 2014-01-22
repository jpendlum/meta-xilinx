
# We use the revision in order to avoid having to fetch it from the
# repo during parse
# Corresponds to github.com/Xilinx tag V14.5
SRCREV = "20a6cdd301941b97961c9c5425b5fbb771321aac"
PV = "v2013.01${XILINX_EXTENSION}"
PR = "r1"

SRC_URI_append_zedboard-zynq7 = "file://fsbl.elf.bz2"
ZYNQ_FSBL = "${WORKDIR}/fsbl.elf"

include u-boot-xlnx.inc

SRC_URI_append += " \
		file://microblaze_bootm_Add_support_for_loading_initrd.patch \
		file://microblaze_bootm_Fix_coding_style_issues.patch \
		file://microblaze_Fix_coding_style_for_bootb.patch \
		file://zynq_common-Add-uEnv.txt-boot-environment-load-suppo.patch \
		file://zynq-Increase-number-of-arguments.patch \
		"
