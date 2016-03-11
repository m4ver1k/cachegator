 <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Connections </h1>
                </div>
                <!-- /.col-lg-12 -->
</div>
<div class="row ng-controller="connection">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Add Connection</div>
			<div class="panel-body">
			<div class="form-group">
					<label>Name</label> <input class="form-control" ng-model="conName">
					<p class="help-block">Name for this connection.</p>
				</div>
				<div class="form-group">
					<label>Host</label> <input class="form-control" ng-model="conHost">
					<p class="help-block">IP or Host of Redis.</p>
				</div>
				<div class="form-group">
					<label>Port</label> <input class="form-control" ng-model="conPort">
					<p class="help-block">Port on which Redis is running.</p>
				</div>
				<div class="form-group" style="display:none">
					<label>Username</label> <input class="form-control">
					<p class="help-block">Username to connect to Redis.</p>
				</div>
				<div class="form-group" style="display:none">
					<label>Password</label> <input class="form-control" type="password">
					<p class="help-block">Password to connect to Redis.</p>
				</div>
				<button type="button" class="btn btn-primary" ng-click="saveConnection()">Save</button>
			</div>
		</div>
</div>
<div class="modal fade" id="conSave" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">Connection Saved</h4>
                                        </div>
                                        <div class="modal-body">
                                            Connection Saved successfully.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
