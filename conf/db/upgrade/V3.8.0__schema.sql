ALTER TABLE VpcFirewallRuleVO MODIFY COLUMN sourceIp varchar(2048) DEFAULT NULL;
ALTER TABLE VpcFirewallRuleVO MODIFY COLUMN destIp varchar(2048) DEFAULT NULL;

DELETE FROM AlarmVO WHERE uuid="e47db726090c47de84521bebc640cfc2";
DELETE FROM ResourceVO WHERE uuid="e47db726090c47de84521bebc640cfc2";

ALTER TABLE `zstack`.`GuestToolsVO` ADD COLUMN agentType VARCHAR(64) DEFAULT "WindowsOnKvm" NOT NULL;