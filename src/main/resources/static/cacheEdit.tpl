 <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit Cache Data</h1>
                </div>
</div>

<div class="row" ng-controller="cacheEdit">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Edit Cache</div>
			<div class="panel-body">
			
			<div class="form-group">
				<label for="cacheList">Name</label>
				<select id="cacheList" class="form-control">
					<option>--Select--</option>
					<option ng-repeat="chd in cacheDetails" value="{{chd.id}}">{{chd.name}}</option>
				</select>
			</div>
			
			<div class="form-group">
				<label for="conList">Connection</label>
				<select id="conList" class="form-control">
					<option ng-repeat="cd in conDetails	" value="{{cd.id}}">{{cd.name}}</option>
				</select>
			</div>
			<div class="form-group">
					<label>Name</label> <input class="form-control" ng-model="cacheName" >
					<p class="help-block">Name for this Cache.</p>
				</div>
				<div class="form-group">
					<label>Description</label> <input class="form-control" ng-model="cacheDescription">
					<p class="help-block">Short Description for this cache.</p>
				</div>
				<div class="form-group">
					<label>DB</label> <input class="form-control" ng-model="cacheDB">
					<p class="help-block">Database number for this cache.</p>
				</div>
				<button type="button" class="btn btn-primary" ng-click="editCache()">Save</button>
			</div>
		</div>
	</div>
</div>
